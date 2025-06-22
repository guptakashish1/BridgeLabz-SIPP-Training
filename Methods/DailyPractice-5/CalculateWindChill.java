import java.util.Scanner;
public class CalculateWindChill{
public static double WindChill(double temp, double windspeed){
        return 35.74 + 0.6215 * temp + (0.4275 * temp - 35.75) * Math.pow(windspeed, 0.16);

}
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
   System.out.print("Enter the temp in Farenheit: ");
   double temp = sc.nextDouble();
   System.out.print("Enter the windSpeed in mph: ");
   double windspeed = sc.nextDouble();
   double windchill = WindChill(temp, windspeed);
   System.out.println("The wind chill is "+ windchill+ "degrees Farhenheit.");
   sc.close();
}
}
