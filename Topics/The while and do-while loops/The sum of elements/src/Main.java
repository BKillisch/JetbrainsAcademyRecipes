import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int sum = 0;
        int next = 1;
        while (next != 0) {
            next = scanner.nextInt();
            sum = sum + next;
        }
        
        System.out.println(sum);
    }
}
