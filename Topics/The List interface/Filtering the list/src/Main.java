import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String out = "";

        while (scanner.hasNextInt()) {
            scanner.nextInt();

            if (scanner.hasNext()) {
                out = scanner.nextInt() + " " + out;
            }
        }

        System.out.println(out);
    }
}