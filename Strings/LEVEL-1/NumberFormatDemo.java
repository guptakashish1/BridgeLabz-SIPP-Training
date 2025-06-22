import java.util.Scanner;

public class NumberFormatDemo {

    public static void generateNumberFormatException(String text) {
        int number = Integer.parseInt(text);
        System.out.println(number);
    }

    public static void handleNumberFormatException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println(number);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        handleNumberFormatException(text);
        scanner.close();
    }
}
