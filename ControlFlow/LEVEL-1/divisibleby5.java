import java.util.Scanner;
public class divisibleby5{
public static void main(String args[]){
Scanner sc = new Scanner(System.in);
System.out.print("enter your number:");
double n = sc.nextDouble();
 boolean isDivisible = (n % 5 == 0);
        System.out.println("Is the number " + n + " divisible by 5? " + isDivisible);
sc.close();
}
}