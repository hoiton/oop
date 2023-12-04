package ch.hslu.oop.sw11.temperature;

import ch.hslu.oop.sw11.CsvReader;
import ch.hslu.oop.sw11.ICsvReader;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TemperatureImporterTest {
    private final String path = "src/test/resources/temperature.csv";
    private final ICsvReader csvReader;
    private final TemperatureImporter importer;

    public TemperatureImporterTest() {
        this.csvReader = mock(ICsvReader.class);
        this.importer = new TemperatureImporter(csvReader);
    }

    @Test
    public void importTemperatures_validPath_returnsTemperatureHistory() {
        // Arrange
        when(csvReader.readAllLines(path)).thenReturn(List.of(
                "1517007843;\"2023/01/27 00:04:03\";6.5;78",
                "1517008150;\"2023/01/27 00:09:10\";6.3;78",
                "1517008459;\"2023/01/27 00:14:19\";6.4;78"
        ));

        // Act
        var history = this.importer.importTemperatures(path);

        // Assert
        assertEquals(3, history.getCount());
        verify(this.csvReader, times(1)).readAllLines(this.path);
    }

    @Test
    public void importTemperatures_noLines_returnsEmptyTemperatureHistory() {
        // Arrange
        when(csvReader.readAllLines(path)).thenReturn(List.of());

        // Act
        var history = this.importer.importTemperatures(path);

        // Assert
        assertEquals(0, history.getCount());
        verify(this.csvReader, times(1)).readAllLines(this.path);
    }
}