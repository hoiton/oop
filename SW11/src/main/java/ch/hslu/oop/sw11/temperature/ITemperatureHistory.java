package ch.hslu.oop.sw11.temperature;

import java.io.FileNotFoundException;
import java.util.Collection;

public interface ITemperatureHistory {
    /**
     * Adds a temperature to the history.
     *
     * @param temperature The temperature to add.
     */
    void addTemperature(Temperature temperature);

    /**
     * Gets the average temperature of the history.
     *
     * @return The average temperature.
     */
    Temperature getAverageTemperature();

    /**
     * Gets the maximum temperature of the history.
     *
     * @return The maximum temperature.
     */
    Temperature getMaxTemperature();

    /**
     * Gets the minimum temperature of the history.
     *
     * @return The minimum temperature.
     */
    Temperature getMinTemperature();

    /**
     * Gets the number of temperatures in the history.
     *
     * @return The number of temperatures.
     */
    int getCount();

    /**
     * Gets the temperatures in the history.
     *
     * @return The temperatures.
     */
    Collection<Temperature> getTemperatures();

    /**
     * Prints the history to the given file
     * @param path The path to the file
     */
    void printToFile(String path);

    /**
     * Reads the history from the given file
     * @param path The path to the file
     */
    void readFromFile(String path) throws FileNotFoundException;
}
