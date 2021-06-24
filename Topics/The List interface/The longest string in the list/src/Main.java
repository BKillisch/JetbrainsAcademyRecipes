import java.util.*;

public class Main {

    static void changeList(List<String> list) {
        list.sort((o1, o2) -> o2.length() - o1.length());

        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(0));
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<String> lst = Arrays.asList(s.split(" "));
        changeList(lst);
        lst.forEach(e -> System.out.print(e + " "));
    }
}