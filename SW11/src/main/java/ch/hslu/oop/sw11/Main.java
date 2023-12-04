package ch.hslu.oop.sw11;

import ch.hslu.oop.sw11.temperature.Temperature;
import ch.hslu.oop.sw11.temperature.TemperatureHistory;
import ch.hslu.oop.sw11.temperature.TemperatureImporter;
import ch.hslu.oop.sw11.temperature.TemperatureInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.ConnectionEvent;
import java.io.*;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    private static final Logger LOG =
            LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var input = scanner.nextLine();
        try (var file = new FileOutputStream("test.txt")){
            try (var output = new DataOutputStream(file)) {
//                output.writeInt(42);
                output.writeUTF(input);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (var file = new FileInputStream("test.txt")){
            try (var input2 = new DataInputStream(file)) {
                System.out.println(input2.readUTF());
//                System.out.println(input2.readFloat());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        Aufgabe1();
        Aufgabe2();
    }

    private static void Aufgabe1(){
        var history = TemperatureInput.start();
        var count = history.getCount();

        history.printToFile("history.txt");

        var newHistory = new TemperatureHistory();
        try {
            newHistory.readFromFile("history.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void Aufgabe2(){
        var csvReader = new CsvReader();
        var tempImporter = new TemperatureImporter(csvReader);
        var history = tempImporter.importTemperatures("netatmo-export-202301-202304.csv");
        history.printToFile("out.txt");
    }
}