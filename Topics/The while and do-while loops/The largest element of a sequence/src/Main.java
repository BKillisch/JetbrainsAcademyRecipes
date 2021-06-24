import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int max = 0;

        while (scanner.hasNextInt()) {
            max = Math.max(max, scanner.nextInt());
        }

        System.out.println(max);
    }
}