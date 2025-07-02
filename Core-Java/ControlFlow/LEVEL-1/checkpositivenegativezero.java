import java.util.Scanner;
public class checkpositivenegativezero{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your number: ");
        double n = sc.nextDouble();
        if (n > 0) {
            System.out.println("The number " + n + " is positive.");
        }
        else if (n < 0) {
            System.out.println("The number " + n + " is negative.");
        }
        else {
            System.out.println("The number is zero.");
        }
        sc.close();
}
}