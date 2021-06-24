import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    private static Map<Character, Integer> countLetters(String s) {
        Map<Character, Integer> res = new HashMap<>();

        for (char c: s.toCharArray()) {
            res.put(c, res.getOrDefault(c, 0) + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (countLetters(scanner.nextLine().toLowerCase()).equals(countLetters(scanner.nextLine().toLowerCase()))) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}