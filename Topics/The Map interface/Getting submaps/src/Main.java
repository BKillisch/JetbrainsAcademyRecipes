import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int low = scanner.nextInt();
        int high = scanner.nextInt() + 1;

        scanner.nextLine();
        scanner.nextLine();

        TreeMap<Integer, String> map = new TreeMap<>();

        while (scanner.hasNextLine()) {
            String[] values = scanner.nextLine().split(" ");
            map.put(Integer.parseInt(values[0]), values[1]);
        }

        for (var s: map.subMap(low, high).entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}