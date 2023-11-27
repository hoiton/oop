package ch.hslu.oop.sw08;

import java.util.ArrayList;
import java.util.Collection;

public class TemperatureHistory implements ITemperatureHistory {
    private final Collection<Temperature> temperatures = new ArrayList<>();

    @Override
    public void addTemperature(Temperature temperature) {
        this.temperatures.add(temperature);
    }

    @Override
    public Temperature getAverageTemperature() {
        var averageKelvin = this.temperatures.stream()
                .map(Temperature::getKelvin)
                .mapToDouble(Double::doubleValue)
                .average();

        if (averageKelvin.isPresent()) {
            return new Temperature(averageKelvin.getAsDouble());
        } else {
            return null;
        }
    }

    @Override
    public Temperature getMaxTemperature() {
        var maxTemperature = this.temperatures.stream().max(Temperature::compareTo);

        return maxTemperature.orElse(null);
    }

    @Override
    public Temperature getMinTemperature() {
        var minTemperature = this.temperatures.stream().min(Temperature::compareTo);

        return minTemperature.orElse(null);
    }

    @Override
    public int getCount() {
        return this.temperatures.size();
    }

    @Override
    public Collection<Temperature> getTemperatures() {
        return this.temperatures;
    }
}
