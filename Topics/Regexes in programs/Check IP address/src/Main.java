import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ip = scanner.nextLine();

        String nums = "(\\d{1,2}|[1]\\d{2}|2([01234]\\d|5[012345]))";
        boolean acceptable = ip.matches(nums + "\\." + nums + "\\." + nums + "\\." + nums);

        System.out.println(acceptable ? "YES" : "NO");
    }
}