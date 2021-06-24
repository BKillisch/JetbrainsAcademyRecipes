import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        Set<String> dict = new HashSet<>();

        for (int i = 0; i < n; i++) {
            dict.add(scanner.nextLine().toLowerCase());
        }

        scanner.nextLine();

        Set<String> text = new HashSet<>();
        while (scanner.hasNext()) {
            text.add(scanner.next().toLowerCase());
        }

        text.removeAll(dict);

        for (String s: text) {
            System.out.println(s);
        }
    }
}