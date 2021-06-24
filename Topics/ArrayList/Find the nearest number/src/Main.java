import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();

        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }

        int n = list.remove(list.size() - 1);

        list.sort(Comparator.comparingInt(o -> Math.abs(o - n)));

        int i = 0;

        l2.add(list.get(i));
        while (i < list.size() - 1 && Math.abs(list.get(i) - n) == Math.abs(list.get(i + 1) - n)) {
            i++;
            l2.add(list.get(i));
        }

        l2.sort(Comparator.comparingInt(o -> o));

        l2.forEach(e -> System.out.print(e + " "));
    }
}