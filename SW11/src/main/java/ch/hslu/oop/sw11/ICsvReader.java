package ch.hslu.oop.sw11;

import java.util.List;

public interface ICsvReader {
    /**
     * Reads all lines from a CSV file.
     * @param path Path to the CSV file.
     * @return List of lines.
     */
    List<String> readAllLines(String path);
}
