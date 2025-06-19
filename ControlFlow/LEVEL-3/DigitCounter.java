import java.util.Scanner;

public class DigitCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input
        System.out.print("Enter an integer: ");
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            int originalNumber = number;  
            int count = 0;
            if (number == 0) {
                count = 1;
            } else {
                number = Math.abs(number);

                
                while (number != 0) {
                    number = number / 10;  
                    count++;              
                }
            }
            System.out.println("Number of digits in " + originalNumber + " is: " + count);

        } else {
            System.out.println("Invalid input. Please enter an integer.");
        }

        scanner.close();
    }
}
