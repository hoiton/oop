package ch.hslu.oop.sw06;

import ch.hslu.oop.sw06.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    public void max_sameNumber_returnsNumber() {
        // Arrange
        int expected = 5;
        int a = 5;
        int b = 5;

        // Act
        int actual = Main.max(a, b);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void max_aBigger_returnsA() {
        // Arrange
        int expected = 5;
        int a = 5;
        int b = 4;

        // Act
        int actual = Main.max(a, b);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void max_bBigger_returnsB() {
        // Arrange
        int expected = 5;
        int a = 4;
        int b = 5;

        // Act
        int actual = Main.max(a, b);

        // Assert
        assertEquals(expected, actual);
    }
}
