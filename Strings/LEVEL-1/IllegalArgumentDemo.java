import java.util.Scanner;

public class IllegalArgumentDemo {

    public static void generateIllegalArgumentException(String text) {
        String result = text.substring(5, 2);
        System.out.println(result);
    }

    public static void handleIllegalArgumentException(String text) {
        try {
            String result = text.substring(5, 2);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        handleIllegalArgumentException(text);
        scanner.close();
    }
}
