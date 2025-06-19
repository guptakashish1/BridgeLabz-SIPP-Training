import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        int[][] marks = new int[numStudents][3];
        double[] percentages = new double[numStudents];
        char[] grades = new char[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter marks for student " + (i + 1) + " (Physics, Chemistry, Maths):");
            for (int j = 0; j < 3; j++) {
                int mark = scanner.nextInt();
                if (mark < 0 || mark > 100) {
                    System.out.println("Invalid mark. Please enter a value between 0 and 100.");
                    j--;
                } else {
                    marks[i][j] = mark;
                }
            }
        }

        for (int i = 0; i < numStudents; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double percentage = total / 3.0;
            percentages[i] = percentage;

            if (percentage >= 80)
                grades[i] = 'A';
            else if (percentage >= 70)
                grades[i] = 'B';
            else if (percentage >= 60)
                grades[i] = 'C';
            else if (percentage >= 50)
                grades[i] = 'D';
            else if (percentage >= 40)
                grades[i] = 'E';
            else
                grades[i] = 'R';
        }

        System.out.println("\nResults:");
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Student " + (i + 1) + ": Physics = " + marks[i][0]
                    + ", Chemistry = " + marks[i][1]
                    + ", Maths = " + marks[i][2]
                    + ", Percentage = " + String.format("%.2f", percentages[i]) + "%"
                    + ", Grade = " + grades[i]);
        }

        scanner.close();
    }
}
