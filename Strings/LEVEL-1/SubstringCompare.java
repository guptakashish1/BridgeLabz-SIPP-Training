import java.util.Scanner;

public class SubstringCompare {

    public static String customSubstring(String text, int start, int end) {
        String res = "";
        for (int i = start; i < end && i < text.length(); i++) {
            res += text.charAt(i);
        }
        return res;
    }

    public static boolean compareStringsCharAt(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.next();
        System.out.print("Start index: ");
        int start = sc.nextInt();
        System.out.print("End index: ");
        int end = sc.nextInt();

        String customSub = customSubstring(str, start, end);
        String builtInSub = "";
        if (start >= 0 && end <= str.length() && start < end) {
            builtInSub = str.substring(start, end);
        }

        boolean areEqual = compareStringsCharAt(customSub, builtInSub);
        System.out.println("Custom Substring: " + customSub);
        System.out.println("Built-in Substring: " + builtInSub);
        System.out.println("Are both equal? " + areEqual);
        sc.close();
    }
}
