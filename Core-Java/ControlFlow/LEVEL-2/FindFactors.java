import java.util.Scanner;

public class FindFactors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get input
        System.out.print("Enter a positive integer: ");
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            
            if (number > 0) {
                System.out.println("Factors of " + number + " are:");
                for (int i = 1; i <= number; i++) {
                    if (number % i == 0) {
                        System.out.println(i);
                    }
                }
            } else {
                System.out.println("The number is not positive.");
            }
        } else {
            System.out.println("Invalid input. Please enter a positive integer.");
        }
        
        scanner.close();
    }
}
