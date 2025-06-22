import java.util.Scanner;

public class StringCompare {

    public static boolean compareStringsUsingCharAt(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String s1 = sc.next();
        System.out.print("Enter second string: ");
        String s2 = sc.next();

        boolean customCompare = compareStringsUsingCharAt(s1, s2);
        boolean builtInCompare = s1.equals(s2);

        System.out.println("Compare using charAt(): " + customCompare);
        System.out.println("Compare using equals(): " + builtInCompare);
        System.out.println("Results match: " + (customCompare == builtInCompare));
        sc.close();
    }
}
