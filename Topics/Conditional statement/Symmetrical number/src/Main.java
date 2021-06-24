import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String num = scanner.nextLine();

        if (num.charAt(0) == num.charAt(3) && num.charAt(1) == num.charAt(2)) {
            System.out.println(1);
        } else {
            System.out.println(2);
        }
    }
}