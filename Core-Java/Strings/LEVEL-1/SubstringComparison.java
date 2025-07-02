import java.util.Scanner;

public class SubstringComparison {
    public static String createSubstring(String text, int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i < end && i < text.length(); i++) {
            result.append(text.charAt(i));
        }

        return result.toString();
    }

   
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input
        System.out.print("Enter the text: ");
        String text = scanner.next();

        System.out.print("Enter start index: ");
        int start = scanner.nextInt();

        System.out.print("Enter end index: ");
        int end = scanner.nextInt();

        // Create substring using custom method
        String customSub = createSubstring(text, start, end);

        // Create substring using built-in method
        String builtInSub = "";
        if (start >= 0 && end <= text.length() && start < end) {
            builtInSub = text.substring(start, end);
        } else {
            System.out.println("Invalid range for built-in substring. Skipping built-in substring.");
        }

        // Compare the substrings
        boolean isSame = compareStrings(customSub, builtInSub);

        // Display results
        System.out.println("\nSubstring using custom method: " + customSub);
        System.out.println("Substring using built-in method: " + builtInSub);
        System.out.println("Both substrings match: " + isSame);
        scanner.close();
    }
}
