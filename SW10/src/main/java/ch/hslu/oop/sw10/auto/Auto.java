package ch.hslu.oop.sw10.auto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Auto implements ISwitchable, PropertyChangeListener {
    private static final Logger LOG =
            LoggerFactory.getLogger(Auto.class);

    private final Motor motor;
    private final Licht licht;

    public Auto(Motor motor, Licht licht) {
        this.motor = motor;
        this.licht = licht;

        this.motor.addPropertyChangeListener(this);
    }

    @Override
    public void switchOn() {
        this.motor.switchOn();
        this.licht.switchOn();
    }

    @Override
    public void switchOff() {
        this.motor.switchOff();
        this.licht.switchOff();
    }

    @Override
    public boolean isSwitchedOn() {
        return this.motor.isSwitchedOn();
    }

    @Override
    public boolean isSwitchedOff() {
        return this.motor.isSwitchedOff();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LOG.info("Property changed: {} -> {}",
                evt.getPropertyName(),
                evt.getNewValue());
    }
}
