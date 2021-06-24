import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.asList(scanner.nextLine().split("\\s*"));

        System.out.println(Collections.frequency(list, scanner.nextLine()));
    }
}