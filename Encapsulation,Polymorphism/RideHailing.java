package Encapsulation_Polymorphism_Interface_Abstract_Class;

abstract class RideVehicle {
    String driver;
    double rate;
    RideVehicle(String driver, double rate) { this.driver = driver; this.rate = rate; }
    abstract double fare(double dist);
}

interface GPS {
    void updateLocation(String loc);
}

class RideCar extends RideVehicle implements GPS {
    RideCar(String driver, double rate) { super(driver, rate); }
    public double fare(double dist) { return dist * rate; }
    public void updateLocation(String loc) { System.out.println("Car at " + loc); }
}

class RideBike extends RideVehicle implements GPS {
    RideBike(String driver, double rate) { super(driver, rate); }
    public double fare(double dist) { return dist * rate; }
    public void updateLocation(String loc) { System.out.println("Bike at " + loc); }
}

public class RideHailing {
    public static void main(String[] args) {
        RideVehicle[] rides = {
            new RideCar("Aman", 12),
            new RideBike("Rohit", 7)
        };
        for (RideVehicle v : rides) {
            ((GPS)v).updateLocation("City Center");
            System.out.println(v.driver + " | Fare: " + v.fare(10));
        }
    }
}
