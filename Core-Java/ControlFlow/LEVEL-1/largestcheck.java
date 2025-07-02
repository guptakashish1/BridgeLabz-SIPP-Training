import java.util.Scanner;
public class largestcheck {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter your 1st no. :");
        double n1 = sc.nextDouble();
        System.out.print("enter your 2nd no. :");
        double n2 = sc.nextDouble();
        System.out.print("enter your 3rd no. :");
        double n3 = sc.nextDouble();
        if ((n1 > n2) && (n1 > n3)) {
            System.out.println(n1 + " is the largest number.");
        } else if ((n2 > n1) && (n2 > n3)) {
            System.out.println(n2 + " is the largest number.");
        } else if ((n3 > n1) && (n3 > n2)) {
            System.out.println(n3 + " is the largest number.");
        } else {
            System.out.println("There is a tie for the largest number.");
        }
        sc.close();
    }
}
