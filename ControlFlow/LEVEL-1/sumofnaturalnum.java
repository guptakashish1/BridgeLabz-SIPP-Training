import java.util.Scanner;
public class sumofnaturalnum {
 public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();
        int sum = 0;
        while (n > 0) {
            sum += n;
            n--;
        }
        System.out.println("Sum of natural numbers: " + sum);
        sc.close();
    }

}
