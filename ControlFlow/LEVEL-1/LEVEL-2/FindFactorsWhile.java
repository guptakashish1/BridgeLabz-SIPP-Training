import java.util.Scanner;

public class FindFactorsWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        if (sc.hasNextInt()) {
            int number = sc.nextInt();

            if (number > 0) {
                System.out.println("Factors of " + number + " are:");
                
                int i = 1;
                while (i <= number) {
                    if (number % i == 0) {
                        System.out.println(i);
                    }
                    i++;
                }
            } else {
                System.out.println("The number is not positive.");
            }
        } else {
            System.out.println("Invalid input. Please enter a positive integer.");
        }

        sc.close();
    }
}
