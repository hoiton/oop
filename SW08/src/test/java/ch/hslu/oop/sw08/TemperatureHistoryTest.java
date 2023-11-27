package ch.hslu.oop.sw08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TemperatureHistoryTest {
    private final ITemperatureHistory history = new TemperatureHistory();

    @Test
    public void addTemperature_valid_addTemperatur() {
        // Arrange
        final var temperature = new Temperature(20.0f);

        // Act
        history.addTemperature(temperature);

        // Assert
        assertTrue(history.getTemperatures().contains(temperature));
    }

    @Test
    public void getAverageTemperature_valid_returnsAverage() {
        // Arrange
        final var temperature1 = new Temperature(20.0f);
        final var temperature2 = new Temperature(30.0f);
        final var temperature3 = new Temperature(40.0f);
        history.addTemperature(temperature1);
        history.addTemperature(temperature2);
        history.addTemperature(temperature3);

        // Act
        final var result = history.getAverageTemperature();

        // Assert
        assertEquals(30.0f, result.getKelvin());
    }

    @Test
    public void getMaxTemperature_valid_returnsMax() {
        // Arrange
        final var temperature1 = new Temperature(20.0f);
        final var temperature2 = new Temperature(30.0f);
        final var temperature3 = new Temperature(40.0f);
        history.addTemperature(temperature1);
        history.addTemperature(temperature2);
        history.addTemperature(temperature3);

        // Act
        final var result = history.getMaxTemperature();

        // Assert
        assertEquals(40.0f, result.getKelvin());
    }

    @Test
    public void getMinTemperature_valid_returnsMin() {
        // Arrange
        final var temperature1 = new Temperature(20.0f);
        final var temperature2 = new Temperature(30.0f);
        final var temperature3 = new Temperature(40.0f);
        history.addTemperature(temperature1);
        history.addTemperature(temperature2);
        history.addTemperature(temperature3);

        // Act
        final var result = history.getMinTemperature();

        // Assert
        assertEquals(20.0f, result.getKelvin());
    }

    @Test
    public void getCount_valid_returnsCount() {
        // Arrange
        final var temperature1 = new Temperature(20.0f);
        final var temperature2 = new Temperature(30.0f);
        final var temperature3 = new Temperature(40.0f);
        history.addTemperature(temperature1);
        history.addTemperature(temperature2);
        history.addTemperature(temperature3);

        // Act
        final var result = history.getCount();

        // Assert
        assertEquals(3, result);
    }

    @Test
    public void getMinTemperature_emptyHistory_returnsNull() {
        // Act
        final var result = history.getMinTemperature();

        // Assert
        assertNull(result);
    }

    @Test
    public void getMaxTemperature_emptyHistory_returnsNull() {
        // Act
        final var result = history.getMaxTemperature();

        // Assert
        assertNull(result);
    }

    @Test
    public void getAverageTemperature_emptyHistory_returnsNull() {
        // Act
        final var result = history.getAverageTemperature();

        // Assert
        assertNull(result);
    }
}