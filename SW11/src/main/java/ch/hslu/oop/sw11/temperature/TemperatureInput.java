package ch.hslu.oop.sw11.temperature;

import java.util.Scanner;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class TemperatureInput {

    private static final Logger LOG =
            LoggerFactory.getLogger(TemperatureInput.class);
    public static ITemperatureHistory start() {
        var temperatureHistory = new TemperatureHistory();
        var minListener = new TemperatureInput.MinListener();
        temperatureHistory.addMinChangedEventListener(minListener);
        var maxListener = new TemperatureInput.MaxListener();
        temperatureHistory.addMaxChangedEventListener(maxListener);

        String input;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Bitte Temperatur eingeben (oder 'exit' zum Beenden): ");
            input = scanner.next();
            try {
               var value = Double.parseDouble(input);
               var temperature = Temperature.fromCelsius(value);
               temperatureHistory.addTemperature(temperature);
                LOG.info(temperature.toString());
            }
            catch (NumberFormatException e) {
                LOG.error("Ungültige Eingabe.", e);
            }
        } while (!"exit".equals(input));

        temperatureHistory.removeMaxChangedEventListener(maxListener);
        temperatureHistory.removeMinChangedEventListener(minListener);

        LOG.info("Durchschnittstemperatur: {}C", temperatureHistory.getAverageTemperature());
        LOG.info("Maximaltemperatur: {}C", temperatureHistory.getMaxTemperature());
        LOG.info("Minimaltemperatur: {}C", temperatureHistory.getMinTemperature());

        return temperatureHistory;

        //LOG.info("Programm beendet.");
    }

    public static class MinListener implements TemperaturMinChangedEventListener {
        @Override
        public void onTemperatureMinEvent(TemperaturMinChangedEvent event) {
            LOG.info("Minimale Temperatur geändert: {}C", event.getNewMinTemperature());
        }
    }

    private static class MaxListener implements TemperaturMaxChangedEventListener {
        @Override
        public void onTemperatureMaxEvent(TemperaturMaxChangedEvent event) {
            LOG.info("Maximale Temperatur geändert: {}", event.getNewMaxTemperature());
        }
    }
}
