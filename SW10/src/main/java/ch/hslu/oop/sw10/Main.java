package ch.hslu.oop.sw10;

import ch.hslu.oop.sw10.auto.Auto;
import ch.hslu.oop.sw10.auto.Licht;
import ch.hslu.oop.sw10.auto.Motor;
import ch.hslu.oop.sw10.temperatureHistory.TemperatureInput;

public class Main {
    public static void main(String[] args) {
        var motor = new Motor();
        var auto = new Auto(motor, new Licht());
        auto.switchOn();
        System.out.println("Hello world!");

        TemperatureInput.start();
    }
}