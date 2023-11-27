package ch.hslu.oop.sw06.unitTesting;

import jdk.jshell.spi.ExecutionControl;

public class Calculator implements ICalculator {

    @Override
    public int add(int a, int b) {
        return Math.addExact(a, b);
    }
}
