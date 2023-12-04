package ch.hslu.oop.sw11.temperature;

import ch.hslu.oop.sw11.ICsvReader;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TemperatureImporter {
    private final ICsvReader csvReader;

    public TemperatureImporter(ICsvReader csvReader) {
        this.csvReader = csvReader;
    }

    /**
     * Imports temperatures from a CSV file.
     * @param path Path to the CSV file.
     * @return Temperature history.
     */
    public ITemperatureHistory importTemperatures(String path) {
        var history = new TemperatureHistory();
        var lines = this.csvReader.readAllLines(path);
        for (String line : lines) {
            var values = line.split(";");
            var temperatureInCelsius = Double.parseDouble(values[2]);
            var timestamp = LocalDateTime.parse(values[1],
                    DateTimeFormatter.ofPattern("\"yyyy/MM/dd HH:mm:ss\""));
            var temperature = Temperature.fromCelsius(temperatureInCelsius, timestamp);
            history.addTemperature(temperature);
        }
        return history;
    }
}
