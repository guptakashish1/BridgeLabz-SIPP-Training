import java.util.Scanner;
public class SumOfNaturalNum {
    public static int FindSum(int n){
        int sum = 0;
        int i = 1;
        while (i <= n) {
            sum += i;
            i++;
        }
        return sum;
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println(" Enter a positive integer.");
        } else {
            int result = FindSum(n);
            System.out.println("Sum of first " + n + " natural numbers is: " + result);
        }
        sc.close();
    }
}

        