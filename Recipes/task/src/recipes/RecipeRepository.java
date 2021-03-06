package recipes;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
    List<Recipe> findAllByNameContainingIgnoreCaseOrderByDateDesc(String string);

    List<Recipe> findAllByCategoryIgnoreCaseOrderByDateDesc(String string);
}
