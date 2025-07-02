import java.util.Scanner;

public class CompareStrings {
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
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();

        boolean charAtResult = compareStrings(str1, str2);
        boolean equalsResult = str1.equals(str2);

        System.out.println("\nComparison using charAt(): " + charAtResult);
        System.out.println("Comparison using String.equals(): " + equalsResult);

        if (charAtResult == equalsResult) {
            System.out.println("Both methods give the same result.");
        }

        scanner.close();
    }
}
