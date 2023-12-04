package ch.hslu.oop.sw11.temperature;

import java.time.LocalDateTime;

public class Temperature implements Comparable<Temperature> {
    public static final double KELVIN_OFFSET = 273.15;
    private final double kelvin;
    private final LocalDateTime timestamp;

    private Temperature(double kelvin, LocalDateTime timestamp) {
        if (kelvin < 0) throw new IllegalArgumentException("Temperature cannot be below 0 Kelvin.");

        this.kelvin = kelvin;
        this.timestamp = LocalDateTime.now();
    }

    /**
     * Creates a new Temperature object from a given Kelvin value.
     * @param kelvin The temperature in Kelvin.
     * @return A new Temperature object.
     * @throws IllegalArgumentException If the given temperature is below 0 Kelvin.
     */
    public static Temperature fromKelvin(double kelvin) {
        return new Temperature(kelvin, null);
    }

    /**
     * Creates a new Temperature object from a given Celsius value.
     * @param celsius The temperature in Celsius.
     * @param timestamp The timestamp of the temperature.
     * @return A new Temperature object.
     * @throws IllegalArgumentException If the given temperature is below 0 Kelvin.
     */
    public static Temperature fromCelsius(double celsius, LocalDateTime timestamp) {
        return new Temperature(convertCelsiusToKelvin(celsius), timestamp);
    }

    /**
     * Creates a new Temperature object from a given Fahrenheit value.
     * @param fahrenheit The temperature in Fahrenheit.
     * @return A new Temperature object.
     * @throws IllegalArgumentException If the given temperature is below 0 Kelvin.
     */
    public static Temperature fromFahrenheit(double fahrenheit) {
        return new Temperature(convertFahrenheitToKelvin(fahrenheit), null);
    }

    public double getKelvin() {
        return kelvin;
    }

    public double getCelsius() {
        return kelvin - KELVIN_OFFSET;
    }

    public double getFahrenheit() {
        return kelvin * 1.8 - 459.67;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public static double convertCelsiusToKelvin(double celsius) {
        return celsius + KELVIN_OFFSET;
    }

    public static double convertFahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit + 459.67) / 1.8;
    }

    @Override
    public int compareTo(Temperature o) {
        return Double.compare(this.kelvin, o.kelvin);
    }
    
    @Override
    public String toString() {
        return String.format("%.2fK", this.kelvin);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Temperature other) {
            return this.kelvin == other.kelvin && this.timestamp.equals(other.timestamp);
        }
        return false;
    }
}
