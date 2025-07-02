public class Vehicle {
    static double registrationFee = 5000.0;
    private String ownerName;
    private String vehicleType;
    private final String registrationNumber;

    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Updated Registration Fee: " + registrationFee);
    }

    public static void displayVehicleDetails(Object obj) {
        if (obj instanceof Vehicle) {
            Vehicle v = (Vehicle) obj;
            System.out.println("\n--- Vehicle Details ---");
            System.out.println("Owner Name: " + v.ownerName);
            System.out.println("Vehicle Type: " + v.vehicleType);
            System.out.println("Registration Number: " + v.registrationNumber);
            System.out.println("Registration Fee: " + registrationFee);
        } else {
            System.out.println("The given object is not a Vehicle instance.");
        }
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Alice", "Car", "KA01AB1234");
        Vehicle v2 = new Vehicle("Bob", "Bike", "MH12XY5678");
        displayVehicleDetails(v1);
        displayVehicleDetails(v2);
        String notAVehicle = "Not a vehicle";
        displayVehicleDetails(notAVehicle);
        updateRegistrationFee(5500.0);
        displayVehicleDetails(v1);
    }
}
