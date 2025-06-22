import java.util.Scanner;

public class ChocolateDivision {
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;
        int remainder = number % divisor;
        return new int[]{quotient, remainder};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of chocolates: ");
        int chocolates = scanner.nextInt();

        System.out.print("Enter number of children: ");
        int children = scanner.nextInt();

        if (chocolates < 0 || children < 0) {
            System.out.println("Chocolates and children count must be non-negative.");
        } else if (children == 0) {
            System.out.println("Cannot divide chocolates among 0 children.");
        } else {
            int[] result = findRemainderAndQuotient(chocolates, children);
            System.out.println("\nDistribution Summary:");
            System.out.println("Each child gets: " + result[0] + " chocolates");
            System.out.println("Remaining chocolates: " + result[1]);
        }

        scanner.close();
    }
}
