import java.util.Scanner;

public class ArmstrongChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter an integer: ");
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            int originalNumber = number;
            int sum = 0;

           
            while (originalNumber != 0) {
                int digit = originalNumber % 10; 
                sum = sum + (digit * digit * digit); 
                originalNumber = originalNumber / 10; 
            }

            
            if (sum == number) {
                System.out.println(number + " is an Armstrong number.");
            } else {
                System.out.println(number + " is not an Armstrong number.");
            }

        } else {
            System.out.println("Invalid input. Please enter a valid integer.");
        }

        scanner.close();
    }
}
