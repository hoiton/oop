package ch.hslu.oop.sw11.temperature;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class TemperatureHistory implements ITemperatureHistory {
    private final Collection<Temperature> temperatures = new ArrayList<>();
    private final Collection<TemperaturMaxChangedEventListener> maxChangedEventListeners = new ArrayList<>();
    private final Collection<TemperaturMinChangedEventListener> minChangedEventListeners = new ArrayList<>();

    @Override
    public void addTemperature(Temperature temperature) {
        var currentMax = this.getMaxTemperature();
        if (currentMax == null || temperature.compareTo(currentMax) > 0) {
            this.fireMaxChangedEvent(new TemperaturMaxChangedEvent(this, temperature));
        }

        var min = this.getMinTemperature();
        if (min == null || temperature.compareTo(min) < 0) {
            this.fireMinChangedEvent(new TemperaturMinChangedEvent(this, temperature));
        }

        this.temperatures.add(temperature);
    }

    @Override
    public Temperature getAverageTemperature() {
        var averageKelvin = this.temperatures.stream()
                .map(Temperature::getKelvin)
                .mapToDouble(Double::doubleValue)
                .average();

        if (averageKelvin.isPresent()) {
            return Temperature.fromKelvin(averageKelvin.getAsDouble());
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

    @Override
    public void printToFile(String path) {
        try (var file = new FileOutputStream(path)) {
            try (var output = new DataOutputStream(file)){
                output.writeInt(this.getCount());
                for (var temp : this.temperatures) {
                    output.writeDouble(temp.getKelvin());
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void readFromFile(String path) throws FileNotFoundException {
        try (var file = new FileInputStream(path)) {
            try (var input = new DataInputStream(file)) {
                var count = input.readInt();
                for (var i = 0; i < count; i++) {
                    this.addTemperature(Temperature.fromKelvin(input.readDouble()));
                }
            }
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addMaxChangedEventListener(TemperaturMaxChangedEventListener listener) {
        this.maxChangedEventListeners.add(listener);
    }

    public void removeMaxChangedEventListener(TemperaturMaxChangedEventListener listener) {
        this.maxChangedEventListeners.remove(listener);
    }

    public void addMinChangedEventListener(TemperaturMinChangedEventListener listener) {
        this.minChangedEventListeners.add(listener);
    }

    public void removeMinChangedEventListener(TemperaturMinChangedEventListener listener) {
        this.minChangedEventListeners.remove(listener);
    }

    private void fireMaxChangedEvent(TemperaturMaxChangedEvent event) {
        for (TemperaturMaxChangedEventListener listener : this.maxChangedEventListeners) {
            listener.onTemperatureMaxEvent(event);
        }
    }

    private void fireMinChangedEvent(TemperaturMinChangedEvent event) {
        for (TemperaturMinChangedEventListener listener : this.minChangedEventListeners) {
            listener.onTemperatureMinEvent(event);
        }
    }
}
