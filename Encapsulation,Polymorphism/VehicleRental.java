package Encapsulation_Polymorphism_Interface_Abstract_Class;

abstract class Vehicle {
    String type;
    double rate;
    Vehicle(String type, double rate) { this.type = type; this.rate = rate; }
    abstract double calcRent(int days);
}

interface Insurable {
    double insurance();
}

class Car extends Vehicle implements Insurable {
    Car(double rate) { super("Car", rate); }
    double calcRent(int d) { return d * rate; }
    public double insurance() { return 1000; }
}

class Bike extends Vehicle implements Insurable {
    Bike(double rate) { super("Bike", rate); }
    double calcRent(int d) { return d * rate; }
    public double insurance() { return 300; }
}

public class VehicleRental {
    public static void main(String[] args) {
        Vehicle[] list = { new Car(800), new Bike(300) };
        for (Vehicle v : list) {
            System.out.println(v.type + " | Rent: " + v.calcRent(3) + " | Insure: " + ((Insurable)v).insurance());
        }
    }
}
