import java.util.Scanner;
public class factorial {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter a positive integer: ");
       int n = sc.nextInt();
       long factorial = 1;
       while (n > 0) {
           factorial *= n;
           n--;
       }
         System.out.println("Factorial is: " + factorial);
         sc.close();
   }
}
