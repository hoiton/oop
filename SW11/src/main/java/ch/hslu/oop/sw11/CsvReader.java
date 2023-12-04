package ch.hslu.oop.sw11;

import ch.hslu.oop.sw11.temperature.Temperature;
import ch.hslu.oop.sw11.temperature.TemperatureInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvReader implements ICsvReader {
    private static final Logger LOG =
            LoggerFactory.getLogger(TemperatureInput.class);

    @Override
    public List<String> readAllLines(String path) {
        var lines = new ArrayList<String>();
        try (var file = new BufferedReader(new FileReader(path))) {
            while (file.ready()) {
                var line = file.readLine();
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            LOG.error("File not found", e);
        } catch (IOException e) {
            LOG.error("IO Exception", e);
        }

        return lines;
    }
}
