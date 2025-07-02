import java.util.Scanner;

public class PalindromeChecker {


    public static String getInput(Scanner scanner) {
        System.out.print("Enter a word or phrase to check: ");
        return scanner.nextLine().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }


    public static void displayResult(boolean isPalindrome) {
        if (isPalindrome) {
            System.out.println("The input is a palindrome.");
        } else {
            System.out.println("The input is not a palindrome.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = getInput(scanner);               
        boolean result = isPalindrome(input);
        displayResult(result);                          

        scanner.close();
    }
}
