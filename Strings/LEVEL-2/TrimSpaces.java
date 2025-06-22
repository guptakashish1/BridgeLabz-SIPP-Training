import java.util.Scanner;

public class TrimSpaces {

    public static int[] findTrimIndices(String text) {
        int start = 0;
        int end = -1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                start = i;
                break;
            }
        }
        for (int i = text.length() - 1; i >= 0; i--) {
            if (text.charAt(i) != ' ') {
                end = i;
                break;
            }
        }
        return new int[]{start, end + 1};
    }

    public static String createSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text with leading and trailing spaces: ");
        String text = sc.nextLine();
        int[] indices = findTrimIndices(text);
        String trimmedByCustom = createSubstring(text, indices[0], indices[1]);
        String trimmedByBuiltIn = text.trim();
        boolean isSame = compareStrings(trimmedByCustom, trimmedByBuiltIn);
        System.out.println("Custom Trim: \"" + trimmedByCustom + "\"");
        System.out.println("Built-in Trim: \"" + trimmedByBuiltIn + "\"");
        System.out.println("Are both equal? " + isSame);
        sc.close();
    }
}
