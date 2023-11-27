package ch.hslu.oop.sw07;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    public void constructor_validArguments_returnsPerson() {
        // Arrange
        String firstName = "Hans";
        String lastName = "Muster";

        // Act
        Person person = new Person(UUID.randomUUID(), firstName, lastName);

        // Assert
        assertNotNull(person);
        assertEquals(firstName, person.getFirstName());
        assertEquals(lastName, person.getLastName());

    }

    @Test
    public void equals_equalValues_returnsTrue() {
        // Arrange
        var id = UUID.randomUUID();
        Person person1 = new Person(id, "Hans", "Muster");
        Person person2 = new Person(id, "Hans", "Muster");

        // Act
        var result = person1.equals(person2);

        // Assert
        assertTrue(result);
    }

    @Test
    public void equals() {
        EqualsVerifier.forClass(Person.class).verify();
    }

    @Test
    public void compareTo_firstPersonIsSmaller_returnsNegative() {
        // Arrange
        Person person1 = new Person(UUID.randomUUID(), "ans", "Muster");
        Person person2 = new Person(UUID.randomUUID(), "xans", "Muster");

        // Act
        var result = person1.compareTo(person2);

        // Assert
        assertTrue(result < 0);
    }

    @Test
    public void compareTo_secondPersonIsSmaller_returnsPositive() {
        // Arrange
        Person person1 = new Person(UUID.randomUUID(), "xans", "Muster");
        Person person2 = new Person(UUID.randomUUID(), "ans", "Muster");

        // Act
        var result = person1.compareTo(person2);

        // Assert
        assertTrue(result > 0);
    }

    @Test
    public void compareTo_sameName_returnsZero() {
        // Arrange
        Person person1 = new Person(UUID.randomUUID(), "Hans", "Muster");
        Person person2 = new Person(UUID.randomUUID(), "Hans", "Muster");

        // Act
        var result = person1.compareTo(person2);

        // Assert
        assertEquals(0, result);
    }
}