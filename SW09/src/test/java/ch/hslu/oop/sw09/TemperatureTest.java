package ch.hslu.oop.sw09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {
    @Test
    public void fromKelvin_valid_returnsTemperature() {
        // Arrange
        final var kelvin = 20.0f;

        // Act
        final var result = Temperature.fromKelvin(kelvin);

        // Assert
        assertEquals(kelvin, result.getKelvin());
    }

    @Test
    public void fromKelvin_temperatureOutOfRange_throwsException() {
        // Arrange
        final var kelvin = -20.0f;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> Temperature.fromKelvin(kelvin));
    }

    @Test
    public void fromCelsius_valid_returnsTemperature() {
        // Arrange
        final var celsius = 20.0f;

        // Act
        final var result = Temperature.fromCelsius(celsius);

        // Assert
        assertEquals(celsius, result.getCelsius());
    }

    @Test
    public void fromCelsius_temperatureOutOfRange_throwsException() {
        // Arrange
        final var celsius = -2000.0f;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> Temperature.fromCelsius(celsius));
    }

    @Test
    public void fromFahrenheit_valid_returnsTemperature() {
        // Arrange
        final var fahrenheit = 20.0f;

        // Act
        final var result = Temperature.fromFahrenheit(fahrenheit);

        // Assert
        assertEquals(fahrenheit, result.getFahrenheit());
    }

    @Test
    public void fromFahrenheit_belowZeroKelvin_throwsException() {
        // Arrange
        final var fahrenheit = -2000.0f;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> Temperature.fromFahrenheit(fahrenheit));
    }

    @Test
    public void convertCelsiusToKelvin_valid_returnsKelvin() {
        // Arrange
        final var celsius = 20.0f;

        // Act
        final var result = Temperature.convertCelsiusToKelvin(celsius);

        // Assert
        assertEquals(celsius + Temperature.KELVIN_OFFSET, result);
    }

    @Test
    public void convertFahrenheitToKelvin_valid_returnsKelvin() {
        // Arrange
        final var fahrenheit = 20.0f;

        // Act
        final var result = Temperature.convertFahrenheitToKelvin(fahrenheit);

        // Assert
        assertEquals((fahrenheit + 459.67) / 1.8, result);
    }

    @Test
    public void compareTo_equal_returnsZero() {
        // Arrange
        final var temperature1 = Temperature.fromKelvin(20.0f);
        final var temperature2 = Temperature.fromKelvin(20.0f);

        // Act
        final var result = temperature1.compareTo(temperature2);

        // Assert
        assertEquals(0, result);
    }

    @Test
    public void compareTo_greater_returnsOne() {
        // Arrange
        final var temperature1 = Temperature.fromKelvin(20.0f);
        final var temperature2 = Temperature.fromKelvin(10.0f);

        // Act
        final var result = temperature1.compareTo(temperature2);

        // Assert
        assertEquals(1, result);
    }

    @Test
    public void compareTo_less_returnsMinusOne() {
        // Arrange
        final var temperature1 = Temperature.fromKelvin(10.0f);
        final var temperature2 = Temperature.fromKelvin(20.0f);

        // Act
        final var result = temperature1.compareTo(temperature2);

        // Assert
        assertEquals(-1, result);
    }
}