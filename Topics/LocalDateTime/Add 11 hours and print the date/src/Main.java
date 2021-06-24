import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(LocalDateTime.parse(scanner.nextLine()).plusHours(11).toLocalDate());
    }
}