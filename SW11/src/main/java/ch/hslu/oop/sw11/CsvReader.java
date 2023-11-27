package ch.hslu.oop.sw11;

import ch.hslu.oop.sw11.temperature.Temperature;
import ch.hslu.oop.sw11.temperature.TemperatureInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.List;

public class CsvReader {
    private static final Logger LOG =
            LoggerFactory.getLogger(TemperatureInput.class);

    public static List<Temperature> read(String path) {
        try (var file = new BufferedReader(new FileReader(path))) {
            while (file.ready()) {
                var line = file.readLine();
                var values = line.split(";");
                var temperature = Temperature.fromCelsius(Double.parseDouble(values[2]));
                LOG.info(temperature.toString());
            }
        } catch (FileNotFoundException e) {
            LOG.error("File not found", e);
        } catch (IOException e) {
            LOG.error("IO Exception", e);
        }

        return null;
    }
}
