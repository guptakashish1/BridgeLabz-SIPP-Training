import java.util.Scanner;

public class SubstringWithCharAt {

    public static String substringUsingCharAt(String str, int start, int end) {
        String result = "";
        for (int i = start; i < end && i < str.length(); i++) {
            result += str.charAt(i);
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
        System.out.print("Enter text: ");
        String str = sc.next();
        System.out.print("Enter start index: ");
        int start = sc.nextInt();
        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        String substrCharAt = substringUsingCharAt(str, start, end);
        String substrBuiltIn = "";
        if (start >= 0 && end <= str.length() && start < end) {
            substrBuiltIn = str.substring(start, end);
        }

        boolean isEqual = compareStrings(substrCharAt, substrBuiltIn);

        System.out.println("Substring using charAt(): " + substrCharAt);
        System.out.println("Substring using substring(): " + substrBuiltIn);
        System.out.println("Both substrings equal: " + isEqual);
        sc.close();
    }
}
