import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LocalDateTime d = LocalDateTime.parse(scanner.nextLine());

        System.out.println((d.getDayOfYear() - 1) * 24 + d.getHour());
    }
}