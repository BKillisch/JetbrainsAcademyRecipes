import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LocalDateTime d = LocalDateTime.parse(scanner.nextLine());
        long n = scanner.nextLong();

        d = d.plusMinutes(n);

        System.out.println(d.getYear() + " " + d.getDayOfYear() + " " + d.toLocalTime());
    }
}