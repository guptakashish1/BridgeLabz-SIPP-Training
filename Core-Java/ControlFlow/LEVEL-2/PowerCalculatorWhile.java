import java.util.Scanner;

public class PowerCalculatorWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer (base number): ");
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();

            System.out.print("Enter a positive integer (power): ");
            if (scanner.hasNextInt()) {
                int power = scanner.nextInt();

                if (number > 0 && power >= 0) {
                    int result = 1;
                    int counter = 0;

                    while (counter < power) {
                        result = result * number;
                        counter++;
                    }

                    System.out.println(number + " raised to the power of " + power + " is: " + result);
                } else {
                    System.out.println("Both number and power must be positive (power can be 0).");
                }
            } else {
                System.out.println("Invalid input for power. Please enter a positive integer.");
            }
        } else {
            System.out.println("Invalid input for number. Please enter a positive integer.");
        }

        scanner.close();
    }
}
