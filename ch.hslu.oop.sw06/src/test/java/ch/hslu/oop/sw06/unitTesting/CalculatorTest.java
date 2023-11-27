package ch.hslu.oop.sw06.unitTesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private final ICalculator testee = new Calculator();

    @Test
    public void add_twoValidNumbers_returnsSum() {
        // Arrange
        int expected = 5;
        int a = 2;
        int b = 3;

        // Act
        int actual = testee.add(a, b);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void add_twoNegativeNumbers_returnsSum() {
        // Arrange
        int expected = -5;
        int a = -2;
        int b = -3;

        // Act
        int actual = testee.add(a, b);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void add_twoLargeNumbers_returnsSum() {
        // Arrange
        int expected = 2147483646;
        int a = 2147483645;
        int b = 1;

        // Act
        int actual = testee.add(a, b);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void add_twoSmallNumbers_returnsSum() {
        // Arrange
        int expected = -2147483646;
        int a = -2147483645;
        int b = -1;

        // Act
        int actual = testee.add(a, b);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void add_positiveIntOverflow_throwsArithmeticException(){
        // Arrange
        int a = 2147483647;
        int b = 1;

        // Act & Assert
        assertThrows(ArithmeticException.class, () -> testee.add(a, b));
    }

    @Test
    public void add_negativeIntOverflow_throwsArithmeticException(){
        // Arrange
        int a = -2147483647;
        int b = -1;

        // Act & Assert
        assertThrows(ArithmeticException.class, () -> testee.add(a, b));
    }
}