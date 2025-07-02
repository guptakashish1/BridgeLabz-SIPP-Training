import java.util.Arrays;

public class RandomStats {

    public static int[] generate4DigitRandomArray(int size) {
        int[] randomNumbers = new int[size];
        for (int i = 0; i < size; i++) {
            randomNumbers[i] = (int)(Math.random() * 9000) + 1000; 
        }
        return randomNumbers;
    }

    public static double[] findAverageMinMax(int[] numbers) {
        int min = numbers[0];
        int max = numbers[0];
        int sum = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            sum += numbers[i];
            min = Math.min(min, numbers[i]);
            max = Math.max(max, numbers[i]);
        }

        double average = sum / (double) numbers.length;
        return new double[] { average, min, max };
    }

    public static void main(String[] args) {
        int[] randomValues = generate4DigitRandomArray(5);
        System.out.println("Generated 4-digit numbers: " + Arrays.toString(randomValues));

        double[] results = findAverageMinMax(randomValues);
        System.out.println("Average: " + results[0]);
        System.out.println("Minimum: " + (int)results[1]);
        System.out.println("Maximum: " + (int)results[2]);
    }
}
