import java.util.Scanner;

public class CompareOnlyCharAt {

    public static boolean compareByCharAt(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input string 1: ");
        String str1 = scanner.next();
        System.out.print("Input string 2: ");
        String str2 = scanner.next();

        boolean result = compareByCharAt(str1, str2);
        System.out.println("Strings equal using charAt(): " + result);
        scanner.close();
    }
}
