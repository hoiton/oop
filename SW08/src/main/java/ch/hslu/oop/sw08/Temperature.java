package ch.hslu.oop.sw08;

public final class Temperature implements Comparable<Temperature> {
    private static final double KELVIN_OFFSET = 273.15;
    private double kelvin;

    public Temperature(double kelvin) {
        this.kelvin = kelvin;
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

    public static double convertCelciusToKelvin(double celsius) {
        return celsius + KELVIN_OFFSET;
    }

    @Override
    public int compareTo(Temperature o) {
        return Double.compare(this.kelvin, o.kelvin);
    }
}
