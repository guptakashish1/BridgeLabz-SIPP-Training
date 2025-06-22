import java.util.Scanner;

public class WindChillCalculator {

    public static double calculateWindChill(double temperature, double windSpeed) {
        if (temperature <= 50 && windSpeed >= 3) {
            return 35.74 + 0.6215 * temperature 
                   - 35.75 * Math.pow(windSpeed, 0.16)
                   + 0.4275 * temperature * Math.pow(windSpeed, 0.16);
        } else {
            return temperature;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temperature (°F): ");
        double temperature = scanner.nextDouble();
        System.out.print("Enter wind speed (mph): ");
        double windSpeed = scanner.nextDouble();

        double windChill = calculateWindChill(temperature, windSpeed);
        System.out.println("Wind chill temperature: " + windChill + " °F");
        scanner.close();
    }
}
