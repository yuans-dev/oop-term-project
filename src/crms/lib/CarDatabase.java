package crms.lib;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CarDatabase extends Database<Car> {

    private final String filename = "cars.txt";

    private static CarDatabase instance;

    private CarDatabase() {
        dataList = new ArrayList<>();
    }

    public static CarDatabase getInstance() {
        if (instance == null) {
            instance = new CarDatabase();
            instance.fetchFromDisk();
        }
        return instance;
    }

    @Override
    public Car getItemById(String id) {
        for (Car car : dataList) {
            if (car.getId() == null ? id == null : car.getId().equals(id)) {
                return car;
            }
        }
        return null;
    }

    @Override
    public void fetchFromDisk() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while (reader.ready()) {
                String text = reader.readLine();
                String[] lineComponents = text.split("###");
                dataList.add(
                        new Car(
                                lineComponents[0], // id
                                lineComponents[1], // brand
                                lineComponents[2], // model
                                lineComponents[3], // description
                                Double.parseDouble(lineComponents[4]) // price
                        ));
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("An exception has occurred while reading " + filename);
        }
    }

    @Override
    public void saveToDisk() {
        try (FileWriter fileWriter = new FileWriter(filename)) {
            StringBuilder toWrite = new StringBuilder();
            for (Car car : dataList) {
                toWrite.append(car.getId()).append("###")
                        .append(car.getBrand()).append("###")
                        .append(car.getModel()).append("###")
                        .append(car.getDescription()).append("###")
                        .append(car.getPrice()).append("\n");
            }
            fileWriter.write(toWrite.toString());
        } catch (IOException e) {
            System.out.println("An exception has occurred while saving to disk.");
        }
    }
}
