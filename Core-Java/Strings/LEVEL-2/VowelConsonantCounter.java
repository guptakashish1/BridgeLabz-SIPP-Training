import java.util.Scanner;

public class VowelConsonantCounter {

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

        return "NotALetter";
    }

    public static int[] countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;

        for (int i = 0;; i++) {
            try {
                char ch = text.charAt(i);
                String type = checkCharType(ch);
                if (type.equals("Vowel")) {
                    vowels++;
                } else if (type.equals("Consonant")) {
                    consonants++;
                }
            } catch (Exception e) {
                break;
            }
        }

        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int[] result = countVowelsAndConsonants(input);
        System.out.println("Vowels: " + result[0]);
        System.out.println("Consonants: " + result[1]);
        sc.close();
    }
}
