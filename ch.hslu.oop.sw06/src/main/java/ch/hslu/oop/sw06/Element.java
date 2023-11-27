package ch.hslu.oop.sw06;

public abstract class Element {
    private final String name;
    private final double boilingTemperature;
    private final double fusionTemperature;

    protected Element(String name, double boilingTemperature, double fusionTemperature) {
        this.name = name;
        this.boilingTemperature = boilingTemperature;
        this.fusionTemperature = fusionTemperature;
    }

    public String getName() {
        return this.name;
    }

    public double getBoilingTemperature() {
        return this.boilingTemperature;
    }

    public double getFusionTemperature() {
        return this.fusionTemperature;
    }

    public boolean isLiquid(double temperature) {
        return temperature >= this.fusionTemperature && temperature < this.boilingTemperature;
    }

    @Override
    public String toString() {
        return "Element{" +
                "name='" + name + "'" +
                ", boilingTemperature=" + boilingTemperature +
                ", fusionTemperature=" + fusionTemperature +
                "}";
    }
}
