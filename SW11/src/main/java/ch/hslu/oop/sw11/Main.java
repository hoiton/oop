package ch.hslu.oop.sw11;

import ch.hslu.oop.sw11.temperature.Temperature;
import ch.hslu.oop.sw11.temperature.TemperatureHistory;
import ch.hslu.oop.sw11.temperature.TemperatureInput;

import javax.sql.ConnectionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        var input = scanner.nextLine();
//        try (var file = new FileOutputStream("test.txt")){
//            try (var output = new DataOutputStream(file)) {
//                output.writeUTF(input);
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        var temps = CsvReader.read("netatmo-export-202301-202304.csv");
        var history = new TemperatureHistory();
        for (Temperature temp : temps) {
            history.addTemperature(temp);
        }

        //        var testI = new TemperatureHistory();
//        try {
//            testI.readFromFile("netatmo-export-202301-202304.csv");
//        } catch (FileNotFoundException e) {
//            System.out.println("File Not Found");
//        }

//        var test = TemperatureInput.start();
//        test.printToFile("history");
    }
}