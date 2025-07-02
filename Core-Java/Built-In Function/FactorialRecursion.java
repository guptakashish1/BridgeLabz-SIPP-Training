import java.util.Scanner;

public class FactorialRecursion {

    
    public static int getInput(Scanner scanner) {
        System.out.print("Enter a non-negative integer: ");
        return scanner.nextInt();
    }

    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1; 
        }
        return n * factorial(n - 1);
    }

    public static void displayResult(int number, long result) {
        System.out.println("Factorial of " + number + " is: " + result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = getInput(scanner);

        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            long result = factorial(number);
            displayResult(number, result);
        }

        scanner.close();
    }
}
