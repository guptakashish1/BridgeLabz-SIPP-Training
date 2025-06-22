import java.util.Scanner;

public class StringToCharCompare {

    public static char[] customToCharArray(String str) {
        char[] chars = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }
        return chars;
    }

    public static boolean compareCharArrays(char[] a, char[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.next();

        char[] customChars = customToCharArray(input);
        char[] builtInChars = input.toCharArray();

        boolean isEqual = compareCharArrays(customChars, builtInChars);

        System.out.println("Custom toCharArray: ");
        for (char c : customChars) System.out.print(c + " ");
        System.out.println("\nBuilt-in toCharArray: ");
        for (char c : builtInChars) System.out.print(c + " ");

        System.out.println("\nArrays are equal: " + isEqual);
        scanner.close();
    }
}
