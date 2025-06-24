import java.time.LocalDate;
import java.util.Scanner;

public class DateArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a date (YYYY-MM-DD): ");
        String inputDate = scanner.nextLine();

        LocalDate date = LocalDate.parse(inputDate);

        LocalDate updatedDate = date.plusDays(7).plusMonths(1).plusYears(2);

        LocalDate finalDate = updatedDate.minusWeeks(3);

        System.out.println("Original Date: " + date);
        System.out.println("After Adding 7 days, 1 month, 2 years: " + updatedDate);
        System.out.println("After Subtracting 3 weeks: " + finalDate);
        scanner.close();
    }
}
