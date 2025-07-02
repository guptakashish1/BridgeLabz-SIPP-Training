import java.util.Scanner;
public class SquareSide{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the perimeter of the square in cm :");
        float perimeter=sc.nextFloat();
        float side = perimeter / 4;
        System.out.printf("The length of the side is = %.2f cm whose perimeter is = %.2f cm%n", side, perimeter);
        sc.close();

    }
}