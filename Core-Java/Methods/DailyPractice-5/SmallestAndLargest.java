import java.util.Scanner;

public class SmallestAndLargest {
    public static int[] findSmallestAndLargest(int number1, int number2, int number3) {
        int smallest = Math.min(number1, Math.min(number2, number3));
        int largest = Math.max(number1, Math.max(number2, number3));
        return new int[]{smallest, largest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = Integer.parseInt(sc.nextLine());
        System.out.print("Enter second number: ");
        int num2 = Integer.parseInt(sc.nextLine());
        System.out.print("Enter third number: ");
        int num3 = Integer.parseInt(sc.nextLine());

        int[] result = findSmallestAndLargest(num1, num2, num3);
        System.out.println("Smallest number is: " + result[0]);
        System.out.println("Largest number is: " + result[1]);
        sc.close();
    }
}
