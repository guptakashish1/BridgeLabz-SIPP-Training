package Encapsulation_Polymorphism_Interface_Abstract_Class;

abstract class Product {
    private String name;
    private double price;
    Product(String name, double price) { this.name = name; this.price = price; }
    public double getPrice() { return price; }
    public String getName() { return name; }
    public abstract double calculateDiscount();
}

interface Taxable {
    double calculateTax();
}

class Electronics extends Product implements Taxable {
    Electronics(String name, double price) { super(name, price); }
    public double calculateDiscount() { return getPrice() * 0.1; }
    public double calculateTax() { return getPrice() * 0.18; }
}

class Groceries extends Product {
    Groceries(String name, double price) { super(name, price); }
    public double calculateDiscount() { return getPrice() * 0.05; }
}

public class E_CommercePlatform {
    public static void main(String[] args) {
        Product[] items = {
            new Electronics("TV", 30000),
            new Groceries("Wheat", 500)
        };

        for (Product p : items) {
            double discount = p.calculateDiscount();
            double tax = (p instanceof Taxable) ? ((Taxable)p).calculateTax() : 0;
            double finalPrice = p.getPrice() + tax - discount;
            System.out.println(p.getName() + " | Final Price: " + finalPrice);
        }
    }
}
