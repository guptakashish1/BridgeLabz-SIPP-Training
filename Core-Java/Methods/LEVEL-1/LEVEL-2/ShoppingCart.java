import java.util.ArrayList;

class CartItem {
    String itemName;
    double price;
    int quantity;

    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }
}

public class ShoppingCart {
    ArrayList<CartItem> cart;

    public ShoppingCart() {
        cart = new ArrayList<>();
    }

    public void addItem(String itemName, double price, int quantity) {
        CartItem item = new CartItem(itemName, price, quantity);
        cart.add(item);
        System.out.println(quantity + " x " + itemName + " added to cart.");
    }

    public void removeItem(String itemName) {
        boolean removed = false;
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).itemName.equalsIgnoreCase(itemName)) {
                cart.remove(i);
                System.out.println(itemName + " removed from cart.");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println(itemName + " not found in cart.");
        }
    }

    public void displayTotalCost() {
        double total = 0;
        System.out.println("\nCart Summary:");
        for (CartItem item : cart) {
            System.out.println(item.itemName + " x" + item.quantity + " = ₹" + item.getTotalPrice());
            total += item.getTotalPrice();
        }
        System.out.println("Total Cost: ₹" + total);
    }

    public static void main(String[] args) {
        ShoppingCart myCart = new ShoppingCart();

        myCart.addItem("T-shirt", 499.99, 2);
        myCart.addItem("Jeans", 1299.50, 1);
        myCart.addItem("Shoes", 2199.00, 1);

        myCart.removeItem("Jeans");

        myCart.displayTotalCost();
    }
}
