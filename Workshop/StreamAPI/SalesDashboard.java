package Workshop.StreamAPI;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

class Order {
    private LocalDate orderDate;
    private List<Item> items;

    public Order(LocalDate orderDate, List<Item> items) {
        this.orderDate = orderDate;
        this.items = items;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public List<Item> getItems() {
        return items;
    }
}

class Store {
    private Map<String, List<Order>> customerOrders;

    public Store(Map<String, List<Order>> customerOrders) {
        this.customerOrders = customerOrders;
    }

    public Map<String, List<Order>> getCustomerOrders() {
        return customerOrders;
    }
}

class Item {
    private String name;
    private String category;
    private double price;

    public Item(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Double.compare(item.price, price) == 0 &&
                name.equals(item.name) &&
                category.equals(item.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, price);
    }

    @Override
    public String toString() {
        return name + " (" + category + ") - $" + price;
    }
}

public class SalesDashboard {
    public static void main(String[] args) {
        // Sample Data Setup (can be extended)
        Map<String, List<Order>> customerOrders1 = new HashMap<>();
        customerOrders1.put("Alice", Arrays.asList(
                new Order(LocalDate.now().minusDays(10), Arrays.asList(new Item("Laptop", "Electronics", 1200), new Item("Mouse", "Electronics", 25))),
                new Order(LocalDate.now().minusDays(20), Arrays.asList(new Item("Keyboard", "Electronics", 80))),
                new Order(LocalDate.now().minusDays(30), Arrays.asList(new Item("Monitor", "Electronics", 300)))
        ));

        Map<String, List<Order>> customerOrders2 = new HashMap<>();
        customerOrders2.put("Bob", Arrays.asList(
                new Order(LocalDate.now().minusDays(15), Arrays.asList(new Item("Shirt", "Clothing", 40))),
                new Order(LocalDate.now().minusDays(25), Arrays.asList(new Item("Shoes", "Clothing", 90))),
                new Order(LocalDate.now().minusDays(35), Arrays.asList(new Item("Watch", "Accessories", 150)))
        ));

        Map<String, List<Order>> customerOrders3 = new HashMap<>();
        customerOrders3.put("Charlie", Arrays.asList(
                new Order(LocalDate.now().minusDays(5), Arrays.asList(new Item("Phone", "Electronics", 700))),
                new Order(LocalDate.now().minusDays(50), Arrays.asList(new Item("Tablet", "Electronics", 450))),
                new Order(LocalDate.now().minusDays(55), Arrays.asList(new Item("Headphones", "Electronics", 120)))
        ));

        Store store1 = new Store(customerOrders1);
        Store store2 = new Store(customerOrders2);
        Store store3 = new Store(customerOrders3);

        Map<String, List<Store>> cityToStoresMap = new HashMap<>();
        cityToStoresMap.put("CityA", Arrays.asList(store1, store2));
        cityToStoresMap.put("CityB", Arrays.asList(store3));

        // Step 4–11 Implementation starts here
        List<Item> allItems = cityToStoresMap.values().stream()
            .flatMap(List::stream) // all stores
            .flatMap(store -> store.getCustomerOrders().entrySet().stream()) // customer orders
            .filter(entry -> entry.getValue().stream()
                    .filter(order -> order.getOrderDate().isAfter(LocalDate.now().minusDays(60)))
                    .limit(3)
                    .count() == 3
            )
            .flatMap(entry -> entry.getValue().stream()) // orders
            .flatMap(order -> order.getItems().stream()) // items
            .distinct() // Step 5 - eliminate duplicates
            .sorted(Comparator.comparingDouble(Item::getPrice).reversed()) // Step 6 - sort by price desc
            .peek(item -> System.out.println("Item flowing: " + item)) // Step 7 - peek
            .skip(2) // Step 8 - skip top 2 expensive items
            .limit(10) // Step 8 - limit next 10
            .collect(Collectors.toList()); // Collect final items

        System.out.println("\nTop Affordable Picks:");
        allItems.forEach(System.out::println);

        // Step 9 - Group by category
        Map<String, List<Item>> groupedByCategory = allItems.stream()
            .collect(Collectors.groupingBy(Item::getCategory));

        System.out.println("\nGrouped by Category:");
        groupedByCategory.forEach((category, items) -> {
            System.out.println(category + ": " + items);
        });

        // Step 10 - Count Electronics items
        long electronicsCount = groupedByCategory.getOrDefault("Electronics", Collections.emptyList()).size();
        System.out.println("\nNumber of items in Electronics category: " + electronicsCount);

        // Step 11 - Check if any item is priced below $500
        boolean hasBelow500 = allItems.stream()
            .anyMatch(item -> item.getPrice() < 500);
        System.out.println("\nIs any item below $500? " + hasBelow500);
    }
}
