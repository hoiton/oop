package ch.hslu.oop.sw10.auto;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class Motor implements ISwitchable {
    private List<PropertyChangeListener> listeners = new ArrayList<>();
    private int rpm = 0;

    @Override
    public void switchOn() {
        this.rpm = 123;
        this.firePropertyChangeEvent(new PropertyChangeEvent(this, "rpm", 0, 123));
    }

    @Override
    public void switchOff() {
        this.rpm = 0;
        this.firePropertyChangeEvent(new PropertyChangeEvent(this, "rpm", 123, 0));
    }

    @Override
    public boolean isSwitchedOn() {
        return this.rpm > 0;
    }

    @Override
    public boolean isSwitchedOff() {
        return this.rpm == 0;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.listeners.add(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.listeners.remove(listener);
    }

    private void firePropertyChangeEvent(final PropertyChangeEvent pcEvent) {
        for (PropertyChangeListener listener : this.listeners) {
            listener.propertyChange(pcEvent);
        }
    }
}
