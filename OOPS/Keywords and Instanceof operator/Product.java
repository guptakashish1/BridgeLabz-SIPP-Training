public class Product {
    static double discount = 10.0;
    private String productName;
    private double price;
    private int quantity;
    private final int productID;

    public Product(String productName, double price, int quantity, int productID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
        System.out.println("Updated Discount: " + discount + "%");
    }

    public static void displayProductDetails(Object obj) {
        if (obj instanceof Product) {
            Product prod = (Product) obj;
            System.out.println("\n--- Product Details ---");
            System.out.println("Product ID: " + prod.productID);
            System.out.println("Name: " + prod.productName);
            System.out.println("Price: $" + prod.price);
            System.out.println("Quantity: " + prod.quantity);
            System.out.println("Discount: " + discount + "%");
        } else {
            System.out.println("The given object is not a Product instance.");
        }
    }

    public static void main(String[] args) {
        Product prod1 = new Product("Laptop", 1500.0, 2, 1001);
        Product prod2 = new Product("Headphones", 200.0, 5, 1002);
        displayProductDetails(prod1);
        displayProductDetails(prod2);
        String notAProduct = "Not a product";
        displayProductDetails(notAProduct);
        updateDiscount(15.0);
        displayProductDetails(prod1);
    }
}
