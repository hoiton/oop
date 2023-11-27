package ch.hslu.oop.sw08.elements;

import ch.hslu.oop.sw08.Temperature;

public abstract class Element {
    private final String name;
    private final double boilingTemperature;
    private final double fusionTemperature;

    protected Element(String name, double boilingTemperature, double fusionTemperature) {
        this.name = name;
        this.boilingTemperature = boilingTemperature;
        this.fusionTemperature = fusionTemperature;
    }

    public final String getName() {
        return this.name;
    }

    public final double getBoilingTemperature() {
        return this.boilingTemperature;
    }

    public final double getFusionTemperature() {
        return this.fusionTemperature;
    }

    public final boolean isLiquid(double temperature) {
        return temperature >= this.fusionTemperature && temperature < this.boilingTemperature;
    }

    public final String getAggregateState(Temperature temp){
        if (temp.getCelsius() <= this.fusionTemperature){
            return "fest";
        } else if (temp.getCelsius() <= this.boilingTemperature){
            return "flüssig";
        } else {
            return "gasförmig";
        }
    }

    @Override
    public String toString() {
        return "Element{" +
                "name='" + this.name + "'" +
                ", boilingTemperature=" + this.boilingTemperature +
                ", fusionTemperature=" + this.fusionTemperature +
                "}";
    }
}
