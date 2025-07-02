import java.util.Scanner;

public class MultiplesBelow100While {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter a positive integer less than 100: ");
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();

            if (number > 0 && number < 100) {
                System.out.println("Multiples of " + number + " below 100 are:");

                int counter = 100;

                while (counter > 1) {
                    if (counter % number == 0) {
                        System.out.println(counter);
                    }
                    counter--;
                }

            } else {
                System.out.println("Number must be positive and less than 100.");
            }
        } else {
            System.out.println("Invalid input. Please enter a positive integer.");
        }

        scanner.close();
    }
}
