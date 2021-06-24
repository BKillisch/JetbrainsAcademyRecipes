import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pw = scanner.nextLine();

        boolean acceptable = pw.matches(".{12,}") && pw.matches(".*[a-z].*")
                            && pw.matches(".*[A-Z].*") && pw.matches(".*\\d.*");

        System.out.println(acceptable ? "YES" : "NO");
    }
}