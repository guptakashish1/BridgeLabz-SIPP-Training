package Encapsulation_Polymorphism_Interface_Abstract_Class;

abstract class FoodItem {
    String name;
    double price;
    int qty;
    FoodItem(String name, double price, int qty) {
        this.name = name; this.price = price; this.qty = qty;
    }
    abstract double totalPrice();
}

interface Discountable {
    double discount();
}

class VegItem extends FoodItem implements Discountable {
    VegItem(String name, double price, int qty) { super(name, price, qty); }
    double totalPrice() { return price * qty; }
    public double discount() { return 5; }
}

class NonVegItem extends FoodItem implements Discountable {
    NonVegItem(String name, double price, int qty) { super(name, price, qty); }
    double totalPrice() { return price * qty + 20; }
    public double discount() { return 10; }
}

public class OnlineFoodDelivery {
    public static void main(String[] args) {
        FoodItem[] items = {
            new VegItem("Paneer", 150, 2),
            new NonVegItem("Chicken", 200, 1)
        };
        for (FoodItem f : items) {
            double bill = f.totalPrice() - ((Discountable)f).discount();
            System.out.println(f.name + " | Final: " + bill);
        }
    }
}

