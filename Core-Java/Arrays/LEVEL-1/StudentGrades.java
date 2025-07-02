import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        int[] physics = new int[n];
        int[] chemistry = new int[n];
        int[] math = new int[n];
        double[] percentage = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1) + ":");

            System.out.print("Physics: ");
            physics[i] = scanner.nextInt();

            System.out.print("Chemistry: ");
            chemistry[i] = scanner.nextInt();

            System.out.print("Math: ");
            math[i] = scanner.nextInt();

            if (physics[i] < 0 || chemistry[i] < 0 || math[i] < 0) {
                System.out.println("Invalid marks! Marks must be non-negative. Please re-enter.");
                i--; // Decrement index to re-enter this student's data
                continue;
            }

            int total = physics[i] + chemistry[i] + math[i];
            percentage[i] = total / 3.0;

            if (percentage[i] >= 80) {
                grade[i] = 'A';
            } else if (percentage[i] >= 70) {
                grade[i] = 'B';
            } else if (percentage[i] >= 60) {
                grade[i] = 'C';
            } else if (percentage[i] >= 50) {
                grade[i] = 'D';
            } else if (percentage[i] >= 40) {
                grade[i] = 'E';
            } else {
                grade[i] = 'R';
            }
        }

        System.out.println("\n--- Student Report ---");
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ":");
            System.out.println("Physics: " + physics[i]);
            System.out.println("Chemistry: " + chemistry[i]);
            System.out.println("Math: " + math[i]);
            System.out.println("Percentage: " + percentage[i] + "%");
            System.out.println("Grade: " + grade[i]);
            System.out.println();
        }

        scanner.close();
    }
}
