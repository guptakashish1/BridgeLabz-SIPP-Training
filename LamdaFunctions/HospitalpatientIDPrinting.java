import java.util.*;

public class HospitalpatientIDPrinting {
    public static void main(String[] args) {
        // List of patient IDs
        List<String> patientIds = Arrays.asList("P101", "P102", "P103", "P104", "P105");

        System.out.println("=== Hospital Patient IDs ===");

        // Using method reference instead of lambda
        patientIds.forEach(System.out::println);
    }
}
