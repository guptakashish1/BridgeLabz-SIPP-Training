import java.util.Scanner;

public class AthleteRounds {
    public static double calculateRounds(double a, double b, double c, double distanceKm) {
        double perimeter = a + b + c;
        double distanceMeters = distanceKm * 1000;
        return distanceMeters / perimeter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter side 1 of the triangle in meters: ");
        double side1 = sc.nextDouble();
        System.out.print("Enter side 2 of the triangle in meters: ");
        double side2 = sc.nextDouble();
        System.out.print("Enter side 3 of the triangle in meters: ");
        double side3 = sc.nextDouble();

        double rounds = calculateRounds(side1, side2, side3, 5);
        System.out.printf("The athlete needs to complete %.2f rounds to run 5 km.%n", rounds);
        sc.close();
    }
}
