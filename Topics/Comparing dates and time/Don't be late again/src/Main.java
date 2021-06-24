import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        scanner.nextLine();

        while (scanner.hasNextLine()) {
            String name = scanner.next();
            LocalTime time = LocalTime.parse(scanner.nextLine().trim() + ":00");

            if (time.isAfter(LocalTime.of(20, 00))) {
                System.out.println(name);
            }
        }
    }
}