import java.util.Scanner;

public class NumberGuessingGame {

    public static int generateGuess(int low, int high) {
        return low + (high - low) / 2; // midpoint strategy (binary search)
    }
    public static String getUserFeedback(Scanner scanner, int guess) {
        System.out.println("Is your number " + guess + "? (Respond with 'low', 'high', or 'correct')");
        return scanner.nextLine().toLowerCase();
    }

    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        int low = 1;
        int high = 100;
        int attempts = 0;

        System.out.println("Think of a number between 1 and 100. I will try to guess it!");

        while (low <= high) {
            int guess = generateGuess(low, high);
            attempts++;
            String feedback = getUserFeedback(scanner, guess);

            if (feedback.equals("correct")) {
                System.out.println("Hooray! I guessed your number in " + attempts + " attempts.");
                break;
            } else if (feedback.equals("low")) {
                // Your number is higher → increase lower bound
                low = guess + 1;
            } else if (feedback.equals("high")) {
                // Your number is lower → decrease upper bound
                high = guess - 1;
            } else {
                System.out.println("Invalid input. Please enter 'low', 'high', or 'correct'.");
                attempts--; // Don't count invalid input
            }
        }

        if (low > high) {
            System.out.println("Hmm, it seems there was a mistake in the feedback.");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        playGame();
    }
}
