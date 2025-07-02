import java.util.Scanner;

public class NchocolateMchildren {

    public static int nCr(int n, int r) {
        if (r > n) return 0;
        if (r == 0 || r == n) return 1;
        int res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (n - i + 1) / i;
        }
        return res;
    }
    public static int calculateWays(int chocolates, int children) {
        return nCr(chocolates + children - 1, children - 1);
    }
    public static int[] getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of chocolates (n): ");
        int n = sc.nextInt();
        System.out.print("Enter the number of children (m): ");
        int m = sc.nextInt();
        sc.close();
        return new int[]{n, m};
    }
    public static void printResult(int chocolates, int children, int ways) {
        System.out.println("Number of ways to distribute " + chocolates + 
                           " chocolates among " + children + " children: " + ways);
    }
    public static void main(String[] args) {
        int[] input = getInput();
        int chocolates = input[0];
        int children = input[1];

        if (chocolates < 0 || children <= 0) {
            System.out.println("Invalid input. Chocolates must be >= 0 and children > 0.");
        } else {
            int ways = calculateWays(chocolates, children);
            printResult(chocolates, children, ways);
        }
    }
}
