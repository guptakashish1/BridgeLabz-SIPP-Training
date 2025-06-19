import java.util.Scanner;

public class BMIStatusChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int number = scanner.nextInt();
        double[] weights = new double[number];
        double[] heights = new double[number];
        double[] bmis = new double[number];
        String[] statuses = new String[number];
        for (int i = 0; i < number; i++) {
            System.out.println("\nEnter details for Person " + (i + 1) + ":");
            double weight;
            do {
                System.out.print("Enter weight (kg): ");
                weight = scanner.nextDouble();
                if (weight <= 0) {
                    System.out.println("Weight must be positive.");
                }
            } while (weight <= 0);
            weights[i] = weight;
            double height;
            do {
                System.out.print("Enter height (m): ");
                height = scanner.nextDouble();
                if (height <= 0) {
                    System.out.println("Height must be positive.");
                }
            } while (height <= 0);
            heights[i] = height;
            bmis[i] = weight / (height * height);
            if (bmis[i] <= 18.4) {
                statuses[i] = "Underweight";
            } else if (bmis[i] <= 24.9) {
                statuses[i] = "Normal";
            } else if (bmis[i] <= 39.9) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obese";
            }
        }

        System.out.println("\n--- BMI REPORT ---");
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Height", "Weight", "BMI", "Status");

        for (int i = 0; i < number; i++) {
            System.out.printf("%-10.2f %-10.2f %-10.2f %-15s\n", heights[i], weights[i], bmis[i], statuses[i]);
        }

        scanner.close();
    }
}
