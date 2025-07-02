public class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double dailyRate;

    // Default Constructor
    public CarRental() {
        customerName = "Unknown";
        carModel = "Standard";
        rentalDays = 1;
        dailyRate = 1000.0; 
    }

    // Parameterized Constructor
    public CarRental(String customerName, String carModel, int rentalDays, double dailyRate) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.dailyRate = dailyRate;
    }

    public double calculateTotalCost() {
        return rentalDays * dailyRate;
    }

    public void displayRentalDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Daily Rate: ₹" + dailyRate);
        System.out.println("Total Cost: ₹" + calculateTotalCost());
        System.out.println("----------------------------------");
    }

    public static void main(String[] args) {
        

        CarRental rental1 = new CarRental();
        System.out.println("Rental 1 (Default Constructor):");
        rental1.displayRentalDetails();

        CarRental rental2 = new CarRental("Kashish Gupta", "Honda City", 5, 1800.0);
        System.out.println("Rental 2 (Parameterized Constructor):");
        rental2.displayRentalDetails();
    }
}
