import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number between 1 and 100: ");
        int number = scanner.nextInt();

        if (number < 1 || number > 100) {
            System.out.println("The entered number must be between 1 and 100.");
        } else {
            long factorial = 1;
            for (int i = 2; i <= number; i++) {
                factorial *= i;
            }
            System.out.println("The factorial of " + number + " is: " + factorial);
        }

        scanner.close();
    }
}