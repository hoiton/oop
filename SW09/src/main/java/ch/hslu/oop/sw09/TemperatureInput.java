package ch.hslu.oop.sw09;

import java.util.Scanner;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class TemperatureInput {

    private static final Logger LOG =
            LoggerFactory.getLogger(TemperatureInput.class);
    public static void start() {
        String input;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Bitte Temperatur eingeben (oder 'exit' zum Beenden): ");
            input = scanner.next();
            try {
               var value = Double.parseDouble(input);
               var temperature = Temperature.fromCelsius(value);
                LOG.info(temperature.toString());
            }
            catch (NumberFormatException e) {
                LOG.error("Ungültige Eingabe.", e);
            }
        } while (!"exit".equals(input));
        LOG.info("Programm beendet.");
    }
}
