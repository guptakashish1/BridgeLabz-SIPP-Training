import java.util.Scanner;

public class NaturalNumberSum {

    public static int recursiveSum(int n) {
        if (n <= 1) return n;
        return n + recursiveSum(n - 1);
    }

    public static int formulaSum(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Not a natural number.");
        } else {
            int recSum = recursiveSum(n);
            int formSum = formulaSum(n);

            System.out.println("Sum using recursion: " + recSum);
            System.out.println("Sum using formula: " + formSum);

            if (recSum == formSum) {
                System.out.println("Both methods give the same result.");
            } else {
                System.out.println("Mismatch in results.");
            }
        }

        sc.close();
    }
}
