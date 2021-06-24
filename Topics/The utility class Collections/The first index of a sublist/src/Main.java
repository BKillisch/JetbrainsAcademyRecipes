import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.asList(scanner.nextLine().split(" "));
        List<String> sublist = Arrays.asList(scanner.nextLine().split(" "));

        System.out.println(Collections.indexOfSubList(list, sublist) + " " + Collections.lastIndexOfSubList(list, sublist));
    }
}