package ch.hslu.oop.sw11.temperature;

public class Temperature implements Comparable<Temperature> {
    public static final double KELVIN_OFFSET = 273.15;
    private final double kelvin;

    private Temperature(double kelvin) {
        if (kelvin < 0) throw new IllegalArgumentException("Temperature cannot be below 0 Kelvin.");

        this.kelvin = kelvin;
    }

    /**
     * Creates a new Temperature object from a given Kelvin value.
     * @param kelvin The temperature in Kelvin.
     * @return A new Temperature object.
     * @throws IllegalArgumentException If the given temperature is below 0 Kelvin.
     */
    public static Temperature fromKelvin(double kelvin) {
        return new Temperature(kelvin);
    }

    /**
     * Creates a new Temperature object from a given Celsius value.
     * @param celsius The temperature in Celsius.
     * @return A new Temperature object.
     * @throws IllegalArgumentException If the given temperature is below 0 Kelvin.
     */
    public static Temperature fromCelsius(double celsius) {
        return new Temperature(convertCelsiusToKelvin(celsius));
    }

    /**
     * Creates a new Temperature object from a given Fahrenheit value.
     * @param fahrenheit The temperature in Fahrenheit.
     * @return A new Temperature object.
     * @throws IllegalArgumentException If the given temperature is below 0 Kelvin.
     */
    public static Temperature fromFahrenheit(double fahrenheit) {
        return new Temperature(convertFahrenheitToKelvin(fahrenheit));
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
}
