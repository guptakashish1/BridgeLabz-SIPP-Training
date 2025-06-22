import java.util.Random;

public class StudentScorecard {

    public static int[][] generateScores(int students) {
        Random rand = new Random();
        int[][] scores = new int[students][3];
        for (int i = 0; i < students; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = rand.nextInt(51) + 50;
            }
        }
        return scores;
    }

    public static double[][] calculateTotalAndPercentage(int[][] scores) {
        double[][] result = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = Math.round((average * 100.0) / 100.0 * 100) / 100.0;
            result[i][0] = total;
            result[i][1] = Math.round(average * 100) / 100.0;
            result[i][2] = percentage;
        }
        return result;
    }

    public static String[] assignGrades(double[][] percentData) {
        String[] grades = new String[percentData.length];
        for (int i = 0; i < percentData.length; i++) {
            double percentage = percentData[i][2];
            if (percentage >= 80) grades[i] = "A";
            else if (percentage >= 70) grades[i] = "B";
            else if (percentage >= 60) grades[i] = "C";
            else if (percentage >= 50) grades[i] = "D";
            else if (percentage >= 40) grades[i] = "E";
            else grades[i] = "R";
        }
        return grades;
    }

    public static void displayScorecard(int[][] scores, double[][] results, String[] grades) {
        System.out.printf("%-8s %-8s %-8s %-8s %-8s %-12s %-8s\n", "Student", "Physics", "Chemistry", "Math", "Total", "Average", "Grade");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-8d %-8d %-8d %-8d %-8.0f %-12.2f %-8s\n", i + 1,
                    scores[i][0], scores[i][1], scores[i][2],
                    results[i][0], results[i][1], grades[i]);
        }
    }

    public static void main(String[] args) {
        int students = 10;
        int[][] scores = generateScores(students);
        double[][] results = calculateTotalAndPercentage(scores);
        String[] grades = assignGrades(results);
        displayScorecard(scores, results, grades);
    }
}
