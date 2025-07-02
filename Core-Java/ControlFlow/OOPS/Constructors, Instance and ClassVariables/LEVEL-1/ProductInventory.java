

public class ProductInventory {
    String productName;
    double price;

    static int totalProducts=0;   // Class Variable

    public ProductInventory( String productName,  double price ){
        this.productName= productName;
        this.price = price;
       totalProducts++;
    }
    public void displayDetails(){
 System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
    }
    public static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }
    public static void main(String[] args) {
       ProductInventory p1 = new ProductInventory("Tablet", 15000);
        ProductInventory p2 = new ProductInventory("Monitor", 12000);

        p1.displayDetails();
        p2.displayDetails();

        ProductInventory.displayTotalProducts();
}
}
