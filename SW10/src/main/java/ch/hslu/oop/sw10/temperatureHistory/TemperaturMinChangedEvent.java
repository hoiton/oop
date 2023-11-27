package ch.hslu.oop.sw10.temperatureHistory;

import java.util.EventObject;

public class TemperaturMinChangedEvent extends EventObject {
    private final Temperature newMinTemperature;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public TemperaturMinChangedEvent(Object source, Temperature newMinTemperature) {
        super(source);
        this.newMinTemperature = newMinTemperature;
    }

    public Temperature getNewMinTemperature() {
        return newMinTemperature;
    }
}
