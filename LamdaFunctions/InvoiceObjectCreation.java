import java.util.*;
import java.util.stream.Collectors;

// Invoice class
class Invoice {
    String transactionId;

    Invoice(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "Invoice generated for Transaction: " + transactionId;
    }
}

public class InvoiceObjectCreation {
    public static void main(String[] args) {
        // List of transaction IDs
        List<String> transactionIds = Arrays.asList("TXN1001", "TXN1002", "TXN1003", "TXN1004");

        System.out.println("=== Transaction IDs ===");
        transactionIds.forEach(System.out::println);

        // Create invoices using constructor reference
        List<Invoice> invoices = transactionIds.stream()
                                               .map(Invoice::new)   // Constructor reference
                                               .collect(Collectors.toList());

        System.out.println("\n=== Generated Invoices ===");
        invoices.forEach(System.out::println);
    }
}
