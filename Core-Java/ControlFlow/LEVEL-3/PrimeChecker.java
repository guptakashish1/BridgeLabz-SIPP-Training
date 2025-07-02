import java.util.Scanner;

public class PrimeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number greater than 1: ");
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();

            if (number > 1) {
                boolean isPrime = true;

                
                for (int i = 2; i < number; i++) {
                    if (number % i == 0) {
                        isPrime = false;
                        break; 
                    }
                }

                if (isPrime) {
                    System.out.println(number + " is a prime number.");
                } else {
                    System.out.println(number + " is not a prime number.");
                }

            } else {
                System.out.println("Number must be greater than 1 to check for prime.");
            }
        } else {
            System.out.println("Invalid input. Please enter an integer.");
        }

        scanner.close();
    }
}
