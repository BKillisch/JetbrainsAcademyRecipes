import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LocalDateTime low = LocalDateTime.parse(scanner.nextLine());
        LocalDateTime high = LocalDateTime.parse(scanner.nextLine());

        if (low.isEqual(high)) {
            System.out.println(0);
            return;
        }

        LocalDateTime temp;

        if (high.isBefore(low)) {
            temp = low;
            low = high;
            high = temp;
        }

        scanner.nextLine();

        int count = 0;

        while (scanner.hasNextLine()) {
            temp = LocalDateTime.parse(scanner.nextLine());

            if (temp.isBefore(high) && (temp.isAfter(low) || temp.isEqual(low))) {
                count++;
            }
        }

        System.out.println(count);
    }
}