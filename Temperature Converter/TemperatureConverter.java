//Add Java imports
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class TemperatureConverter {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> temperatureFahrenheit = new ArrayList<>();
        
        System.out.println("Enter temperature values in Celsius (type 'end' to finish): ");
        
        while (scanner.hasNextDouble()){
            double tempCelsius = scanner.nextDouble();
            double tempFahrenheit = convertCelsiusToFahrenheit(tempCelsius);
            temperatureFahrenheit.add(tempFahrenheit);
        }

        //Skip the non numeric input that ends the loop
        scanner.next();

        if (!temperatureFahrenheit.isEmpty()){
            double average = temperatureFahrenheit.stream().mapToDouble(val -> val).average().orElse(0.0);
            double min = Collections.min(temperatureFahrenheit);
            double max = Collections.max(temperatureFahrenheit);
            double range = max - min;

            System.out.println("Average temperature in Fahrenheit: " + average);
            System.out.println("Lowest temperature in Fahrenheit: " + min);
            System.out.println("Highest temperature in Fahrenheit: " + max);
            System.out.println("Temperature range in Fahrenheit: " + range);
        } else {
            System.out.println("No temperatures were entered.");
        }

        scanner.close();

    }    
        public static double convertCelsiusToFahrenheit(double tempCelsius) {
            return (tempCelsius - 32) * 5/9;
        }
}