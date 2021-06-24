package recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@Validated
public class RecipeController {
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/api/recipe/search")
    public Recipe[] searchRecipes(@RequestParam(name = "category", required = false, defaultValue = "") String category,
                                  @RequestParam(name = "name", required = false, defaultValue = "") String name) {

        System.out.println("Search: " + category + "; " + name);

        if (category.isEmpty() == name.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        if (!category.isEmpty()) {
            return recipeRepository.findAllByCategoryIgnoreCaseOrderByDateDesc(category).toArray(new Recipe[0]);
        } else {
            return recipeRepository.findAllByNameContainingIgnoreCaseOrderByDateDesc(name).toArray(new Recipe[0]);
        }
    }

    @GetMapping("/api/recipe/{id}")
    public Recipe getRecipe(@PathVariable int id) {
        Optional<Integer> oid = Optional.of(id);

        if (oid.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Please enter a valid Integer!");
        }
        System.out.println("Get: " + oid.get());

        Optional<Recipe> recipeOptional = recipeRepository.findById(oid.get());

        if (recipeOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return recipeOptional.get();
    }

    @PostMapping(value = "/api/recipe/new", produces = MediaType.APPLICATION_JSON_VALUE)
    public IDWrapper newRecipe(@Valid @RequestBody Recipe recipe, Authentication authentication) {

        recipe.setDate(LocalDateTime.now().toString());
        recipe.setUser(getCurrentUser(authentication));
        getCurrentUser(authentication).addRecipe(recipe);
        System.out.println("New: " + recipe);
        return new IDWrapper(recipeRepository.save(recipe).getId());
    }

    @PostMapping("/api/register")
    public ResponseEntity<Void> register(@Valid @RequestBody User user) {
        if (userRepository.existsById(user.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/api/recipe/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable int id, Authentication authentication) {
        Optional<Integer> oid = Optional.of(id);

        if (oid.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Please enter a valid Integer!");
        }
        System.out.println("Delete: " + oid.get());

        Optional<Recipe> recipe = recipeRepository.findById(oid.get());

        if (recipe.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no recipe with this id!");
        }

        if (!getCurrentUser(authentication).ownsRecipe(recipe.get())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You do not own this recipe!");
        }

        getCurrentUser(authentication).deleteRecipe(recipe.get());
        recipeRepository.deleteById(oid.get());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/api/recipe/{id}")
    public ResponseEntity<Void> updateRecipe(@Valid @RequestBody Recipe recipe, @PathVariable int id, Authentication authentication) {
        Optional<Integer> oid = Optional.of(id);

        if (oid.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Please enter a valid Integer!");
        }

        Optional<Recipe> recipeOptional = recipeRepository.findById(oid.get());

        if (recipeOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no recipe with this id!");
        }

        if (recipeOptional.get().getUser() != getCurrentUser(authentication)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }

        System.out.println("Put: " + oid.get());

        Recipe newRecipe = recipeOptional.get();

        newRecipe.setName(recipe.getName());
        newRecipe.setCategory(recipe.getCategory());
        newRecipe.setDescription(recipe.getDescription());
        newRecipe.setIngredients(recipe.getIngredients());
        newRecipe.setDirections(recipe.getDirections());

        newRecipe.setDate(LocalDateTime.now().toString());

        recipeRepository.save(newRecipe);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private User getCurrentUser(Authentication authentication) {
        System.out.println(userRepository.findById(authentication.getName()).get());
        return userRepository.findById(authentication.getName()).get();
    }
}
