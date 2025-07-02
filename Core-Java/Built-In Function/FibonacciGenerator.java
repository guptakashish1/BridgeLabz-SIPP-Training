import java.util.Scanner;

public class FibonacciGenerator {

   
    public static void generateFibonacci(int terms) {
        int first = 0, second = 1;

        System.out.print("Fibonacci Sequence: ");
        for (int i = 1; i <= terms; i++) {
            System.out.print(first + " ");

            
            int next = first + second;
            first = second;
            second = next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of terms: ");
        int terms = scanner.nextInt();

        if (terms <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            generateFibonacci(terms);
        }

        scanner.close();
    }
}
