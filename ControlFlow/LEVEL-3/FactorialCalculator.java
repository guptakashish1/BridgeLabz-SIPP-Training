import java.util.Scanner;

public class FactorialCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();

            if (number >= 0) {
                int factorial = 1;
                int counter = 1;

                while (counter <= number) {
                    factorial = factorial * counter;
                    counter++;
                }

                System.out.println("Factorial of " + number + " is: " + factorial);
            } else {
                System.out.println("Please enter a non-negative integer.");
            }
        } else {
            System.out.println("Invalid input. Please enter an integer.");
        }

        scanner.close();
    }
}
