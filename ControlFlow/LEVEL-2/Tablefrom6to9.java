import java.util.Scanner;
public class Tablefrom6to9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a num between 6 and 9: ");
        int number = sc.nextInt();
        if (number >= 6 && number <= 9) {
            System.out.println("Multiplication table for " + number + ":");
            for (int i = 1; i <= 10; i++) {
                System.out.println(number + " x " + i + " = " + (number * i));
            }
        } else {
            System.out.println("Please enter a valid num between 6 and 9.");
        }
        sc.close();
    }
}
