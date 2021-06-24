import java.util.*;

class MapUtils {

    public static SortedMap<String, Integer> wordCount(String[] strings) {
        SortedMap<String, Integer> res = new TreeMap<>();

        for (String s: strings) {
            res.put(s, res.getOrDefault(s, 0) + 1);
        }

        return res;
    }

    public static void printMap(Map<String, Integer> map) {
        for (var e: map.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        MapUtils.printMap(MapUtils.wordCount(words));
    }
}