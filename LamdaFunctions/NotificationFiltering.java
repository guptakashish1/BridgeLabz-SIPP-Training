import java.util.*;
import java.util.function.Predicate;

class Alert {
    String type;
    String message;

    Alert(String type, String message) {
        this.type = type;
        this.message = message;
    }

    @Override
    public String toString() {
        return "[" + type + "] " + message;
    }
}

public class NotificationFiltering {
    public static void main(String[] args) {
        // List of alerts
        List<Alert> alerts = Arrays.asList(
            new Alert("Emergency", "Patient needs immediate attention!"),
            new Alert("Appointment", "Your check-up is scheduled for tomorrow."),
            new Alert("General", "Stay hydrated and take medicines on time."),
            new Alert("Emergency", "ICU bed required immediately."),
            new Alert("Appointment", "Dentist appointment confirmed.")
        );

        System.out.println("=== All Alerts ===");
        alerts.forEach(System.out::println);

        // User preferences using Predicate
        Predicate<Alert> showOnlyEmergency = alert -> alert.type.equals("Emergency");
        Predicate<Alert> showAppointments = alert -> alert.type.equals("Appointment");
        Predicate<Alert> showNonEmergency = alert -> !alert.type.equals("Emergency");

        // Apply filtering
        System.out.println("\n=== Emergency Alerts Only ===");
        alerts.stream().filter(showOnlyEmergency).forEach(System.out::println);

        System.out.println("\n=== Appointment Alerts Only ===");
        alerts.stream().filter(showAppointments).forEach(System.out::println);

        System.out.println("\n=== Non-Emergency Alerts ===");
        alerts.stream().filter(showNonEmergency).forEach(System.out::println);
    }
}
