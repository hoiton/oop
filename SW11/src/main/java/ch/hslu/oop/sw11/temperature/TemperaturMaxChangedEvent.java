package ch.hslu.oop.sw11.temperature;

import java.util.EventObject;

public class TemperaturMaxChangedEvent extends EventObject {
    private final Temperature newMaxTemperature;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public TemperaturMaxChangedEvent(Object source, Temperature newMaxTemperature) {
        super(source);
        this.newMaxTemperature = newMaxTemperature;
    }

    public Temperature getNewMaxTemperature() {
        return this.newMaxTemperature;
    }
}
