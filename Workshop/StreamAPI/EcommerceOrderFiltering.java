package Workshop.StreamAPI;
import java.util.*;
import java.util.stream.Collectors;

class Ecommerce {
    String id;
    String customername;
    double amount;
    String status;

    Ecommerce(String id, String customername, double amount, String status) {
        this.id = id;
        this.customername = customername;
        this.amount = amount;
        this.status = status;
    }

    @Override
    public String toString() {
        return id + " | " + customername + " | " + amount + " | " + status;
    }
}

public class EcommerceOrderFiltering {
    public static void main(String[] args) {
        List<Ecommerce> orders = Arrays.asList(
            new Ecommerce("001", "alice", 250.75, "delivered"),
            new Ecommerce("002", "bob", 120.50, "pending"),
            new Ecommerce("003", "manya", 205, "cancelled"),
            new Ecommerce("004", "kashish", 320.00, "cancelled"),
            new Ecommerce("005", "abhay", 450.25, "delivered"),
            new Ecommerce("006", "isha", 80.00, "cancelled"),
            new Ecommerce("007", "alice", 300.00, "delivered")
        );

        System.out.println("all orders");
        orders.forEach(System.out::println);

        // 1. Total revenue from delivered orders
        double totalRevenue = orders.stream()
                .filter(order -> order.status.equalsIgnoreCase("delivered"))
                .mapToDouble(order -> order.amount)
                .sum();
        System.out.println("\nTotal revenue (DELIVERED): " + totalRevenue);
 // 2. List of customers with cancelled orders
        List<String> cancelledcustomers = orders.stream()
                .filter (order -> order.status.equalsIgnoreCase( "cancelled"))
                .map( order -> order.customername)
                .distinct()
                .collect(Collectors.toList());
                System.out.println( "\nCancelled customers:"+ cancelledcustomers);
        
       
    }
}
