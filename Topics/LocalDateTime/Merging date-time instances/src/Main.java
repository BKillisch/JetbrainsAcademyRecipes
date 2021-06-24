import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static LocalDateTime merge(LocalDateTime d1, LocalDateTime d2) {
        return LocalDateTime.of(Math.max(d1.getYear(), d2.getYear()), Math.max(d1.getMonthValue(), d2.getMonthValue()),
                Math.max(d1.getDayOfMonth(), d2.getDayOfMonth()), Math.max(d1.getHour(), d2.getHour()),
                Math.max(d1.getMinute(), d2.getMinute()), Math.max(d1.getSecond(), d2.getSecond()));
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final LocalDateTime firstDateTime = LocalDateTime.parse(scanner.nextLine());
        final LocalDateTime secondDateTime = LocalDateTime.parse(scanner.nextLine());
        System.out.println(merge(firstDateTime, secondDateTime));
    }
}