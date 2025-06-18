
import java.util.Scanner;
public class BasicCalculator{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        float number1 = sc.nextFloat();
        
        System.out.print("Enter second number: ");
        float number2 = sc.nextFloat();
        
        // Performing arithmetic operations
        float addition = number1 + number2;
        float subtraction = number1 - number2;
        float multiplication = number1 * number2;
        float division = number1 / number2;
        System.out.println("the addition of " + number1 + " and " + number2 + " is : " + addition);
        System.out.println("the subtraction of " + number1 + " and " + number2 + " is :" + subtraction);
        System.out.println("the multiplication of " + number1 + " and " + number2 + " is :" + multiplication);
        System.out.println("the division of " + number1 + " and " + number2 + " is :" + division);
        
        sc.close();

    }
}