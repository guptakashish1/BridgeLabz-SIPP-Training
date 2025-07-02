import java.util.Arrays;
import java.util.Scanner;

public class NumberChecker {

    public static int countDigits(int number) {
        return String.valueOf(number).length();
    }

    public static int[] getDigitsArray(int number) {
        String str = String.valueOf(number);
        int[] digits = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            digits[i] = str.charAt(i) - '0';
        }
        return digits;
    }

    public static int[] reverseArray(int[] arr) {
        int[] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }

    public static boolean compareArrays(int[] arr1, int[] arr2) {
        return Arrays.equals(arr1, arr2);
    }

    public static boolean isPalindrome(int number) {
        int[] digits = getDigitsArray(number);
        int[] reversed = reverseArray(digits);
        return compareArrays(digits, reversed);
    }

    public static boolean isDuckNumber(int number) {
        int[] digits = getDigitsArray(number);
        for (int i = 1; i < digits.length; i++) {  
            if (digits[i] == 0) return true;
        }
        return false;
    }

   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        System.out.println("Digit count: " + countDigits(number));

        int[] digits = getDigitsArray(number);
        System.out.println("Digits: " + Arrays.toString(digits));

        int[] reversed = reverseArray(digits);
        System.out.println("Reversed Digits: " + Arrays.toString(reversed));

        boolean isPal = isPalindrome(number);
        System.out.println("Is Palindrome: " + isPal);

        boolean isDuck = isDuckNumber(number);
        System.out.println("Is Duck Number: " + isDuck);

        sc.close();
    }
}
