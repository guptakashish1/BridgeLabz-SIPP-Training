import java.util.Scanner;

public class VowelConsonantType {

    public static String checkCharType(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32);
        }

        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }

        return "Not a Letter";
    }

    public static String[][] getCharTypes(String text) {
        int len = 0;
        for (;;) {
            try {
                text.charAt(len);
                len++;
            } catch (Exception e) {
                break;
            }
        }

        String[][] result = new String[len][2];

        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = checkCharType(ch);
        }

        return result;
    }

    public static void displayCharTypes(String[][] array) {
        System.out.println("Character\tType");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i][0] + "\t\t" + array[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[][] charTypes = getCharTypes(input);
        displayCharTypes(charTypes);
        sc.close();
    }
}
