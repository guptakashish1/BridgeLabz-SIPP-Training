import java.util.Scanner;

public class EmployeeBonusCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int EMPLOYEE_COUNT = 10;
        double[] salary = new double[EMPLOYEE_COUNT];
        double[] yearsOfService = new double[EMPLOYEE_COUNT];
        double[] bonus = new double[EMPLOYEE_COUNT];
        double[] newSalary = new double[EMPLOYEE_COUNT];

        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1) + ":");

            System.out.print("Enter salary: ");
            double s = scanner.nextDouble();

            System.out.print("Enter years of service: ");
            double y = scanner.nextDouble();

            if (s <= 0 || y < 0) {
                System.out.println("Invalid input! Salary must be > 0 and years of service must be >= 0. Try again.");
                i--;
                continue;
            }

            salary[i] = s;
            yearsOfService[i] = y;
        }

        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            if (yearsOfService[i] > 5) {
                bonus[i] = 0.05 * salary[i];
            } else {
                bonus[i] = 0.02 * salary[i];
            }

            newSalary[i] = salary[i] + bonus[i];

            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }

        System.out.println("\n--- Employee Bonus Summary ---");
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            System.out.println("Employee " + (i + 1) + ":");
            System.out.println("Old Salary: " + salary[i]);
            System.out.println("Years of Service: " + yearsOfService[i]);
            System.out.println("Bonus: " + bonus[i]);
            System.out.println("New Salary: " + newSalary[i]);
            System.out.println();
        }

        System.out.println("--- Company Summary ---");
        System.out.println("Total Bonus Paid: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);

        scanner.close();
    }
}
