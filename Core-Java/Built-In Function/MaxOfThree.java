import java.util.Scanner;

public class MaxOfThree {

    public static int[] getInput() {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            nums[i] = scanner.nextInt();
        }
        scanner.close();
        return nums;
    }

    public static int findMaximum(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        int[] numbers = getInput();
        int max = findMaximum(numbers[0], numbers[1], numbers[2]);
        System.out.println("The maximum number is: " + max);
    }
}
