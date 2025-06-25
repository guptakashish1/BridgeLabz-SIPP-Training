import java.util.Scanner;
public class rocketcountdown {
   public static void main(String[]args){
         Scanner sc = new Scanner(System.in);
            System.out.print("Enter the countdown time in seconds: ");
            int countdownTime = sc.nextInt();
            for (int i = countdownTime; i >= 1; i--) {
                System.out.println(i + " seconds remaining");
            }
         System.out.println("Liftoff! 🚀");

        sc.close();
   } 
}
