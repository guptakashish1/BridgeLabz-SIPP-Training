import java.util.Scanner;

public class StringLengthWithoutLengthMethod {

    public static int getLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        int customLength = getLength(text);
        int builtInLength = text.length();
        System.out.println("Custom Length: " + customLength);
        System.out.println("Built-in Length: " + builtInLength);
        sc.close();
    }
}
