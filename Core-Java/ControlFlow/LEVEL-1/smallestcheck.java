import java.util.Scanner;
public class smallestcheck {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter your 1st number:");
        double n1= sc.nextDouble();
        System.out.print("enter 2nd number:");
        double n2 = sc.nextDouble();
        System.out.print("enter 3rd number:");
        double n3 = sc.nextDouble();
        boolean isSmallest = (n1 < n2) && (n1 < n3);
        System.out.println("Is the first number the smallest? " + isSmallest);
        
        sc.close();
    }
}
