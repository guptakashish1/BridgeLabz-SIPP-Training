import java.util.Random;

public class EmployeeBonusCalculator {

    public static int[][] generateEmployeeData(int numEmployees) {
        Random rand = new Random();
        int[][] data = new int[numEmployees][2]; // [salary, yearsOfService]
        for (int i = 0; i < numEmployees; i++) {
            int salary = rand.nextInt(90000) + 10000; // 5-digit salary (10000 to 99999)
            int yearsOfService = rand.nextInt(11); // 0 to 10 years
            data[i][0] = salary;
            data[i][1] = yearsOfService;
        }
        return data;
    }

    public static double[][] calculateBonusAndNewSalary(int[][] employeeData) {
        int n = employeeData.length;
        double[][] result = new double[n][2]; // [newSalary, bonus]
        for (int i = 0; i < n; i++) {
            int salary = employeeData[i][0];
            int years = employeeData[i][1];
            double bonus = (years > 5) ? 0.05 * salary : 0.02 * salary;
            double newSalary = salary + bonus;
            result[i][0] = newSalary;
            result[i][1] = bonus;
        }
        return result;
    }

    public static void displaySummary(int[][] employeeData, double[][] salaryBonusData) {
        double totalOldSalary = 0, totalNewSalary = 0, totalBonus = 0;

        System.out.printf("%-5s %-10s %-10s %-12s %-12s %-10s\n", "ID", "Salary", "Years", "Bonus", "New Salary", "Rate");

        for (int i = 0; i < employeeData.length; i++) {
            int salary = employeeData[i][0];
            int years = employeeData[i][1];
            double bonus = salaryBonusData[i][1];
            double newSalary = salaryBonusData[i][0];
            String rate = (years > 5) ? "5%" : "2%";

            totalOldSalary += salary;
            totalNewSalary += newSalary;
            totalBonus += bonus;

            System.out.printf("%-5d %-10d %-10d %-12.2f %-12.2f %-10s\n", 
                (i + 1), salary, years, bonus, newSalary, rate);
        }

        System.out.println("--------------------------------------------------------------");
        System.out.printf("TOTAL  %-10.2f %-22.2f %-12.2f\n", totalOldSalary, totalNewSalary, totalBonus);
    }

    public static void main(String[] args) {
        int[][] employeeData = generateEmployeeData(10);
        double[][] salaryBonusData = calculateBonusAndNewSalary(employeeData);
        displaySummary(employeeData, salaryBonusData);
    }
}
