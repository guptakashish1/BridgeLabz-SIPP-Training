import java.util.Scanner;

public class GreatestFactorWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();

            if (number > 1) {
                int greatestFactor = 1;  
                int counter = number - 1;  

                while (counter >= 1) {
                    if (number % counter == 0) {
                        greatestFactor = counter;
                        break;  
                    }
                    counter--;
                }

                System.out.println("The greatest factor of " + number + " (besides itself) is: " + greatestFactor);
            } else {
                System.out.println("Please enter a positive integer greater than 1.");
            }
        } else {
            System.out.println("Invalid input. Please enter a positive integer.");
        }

        scanner.close();
    }
}
