import java.util.*;


class MapFunctions {

    public static void calcTheSamePairs(Map<String, String> map1, Map<String, String> map2) {
        if (map1 == null || map2 == null) {
            System.out.println(0);
        }else {
            int count = 0;

            for (var e : map1.entrySet()) {
                if (e.getValue().equals(map2.get(e.getKey()))) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}