package ch.hslu.oop.sw06.unitTesting;

/**
 * Interface for a simple calculator.
 */
public interface ICalculator {
    /**
     * Adds two integers and returns the result.
     * @param a Number 1
     * @param b Number 2
     * @return Sum of a and b
     * @throws ArithmeticException if the result overflows an int
     */
    int add(int a, int b);
}
