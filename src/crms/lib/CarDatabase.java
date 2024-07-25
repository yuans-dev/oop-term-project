/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crms.lib;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * CarInventory class is responsible for managing the collection of recorded
 * <code>Car</code> objects in the local database and performing various
 * operations related to them.
 * <p>
 * It implements the singleton pattern to ensure only one instance of the class
 * exists.
 * </p>
 * <p>
 * It provides methods to add, remove, and retrieve <code>Car</code> objects,
 * generate reports, and handle data persistence to a local file.
 * </p>
 *
 * @author Yuan Suarez
 * @version 1.0
 */
public class CarDatabase extends Database<Car> {

    private final String filename = "cars.txt";
    private static CarDatabase instance;

    /**
     * Private constructor to prevent instantiation. Initializes the
     * <code>cars</code> list.
     */
    private CarDatabase() {
        dataList = new ArrayList<>();
    }

    /**
     * Returns the singleton instance of {@code RentalService}. If the instance
     * does not exist, it is created and the cars are fetched from disk.
     *
     * @return the singleton instance of {@code CarInventory}.
     */
    public static CarDatabase getInstance() {
        if (instance == null) {
            instance = new CarDatabase();
            instance.fetchFromDisk();
        }
        return instance;
    }

    /**
     * Retrieves a {@code Car} object using the given ID.
     *
     * @param id the ID of the car to be retrieved
     * @return the {@code Car} object with the specified ID, or null if not
     * found
     */
    public Car getItemById(String id) {
        for (Car car : dataList) {
            if (car.getId() == null ? id == null : car.getId().equals(id)) {
                return car;
            }
        }
        return null;
    }

    /**
     * Fetches the recorded {@code Car} objects from the file {@code cars.txt}.
     *
     */
    public void fetchFromDisk() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while (reader.ready()) {
                String text = reader.readLine();
                String[] lineComponents = text.split("###");
                dataList.add(
                        new Car(
                                lineComponents[0],//id
                                lineComponents[1],//brand
                                lineComponents[2],//model
                                lineComponents[3],//description
                                Double.parseDouble(lineComponents[4])//price
                        ));
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("An exception has occurred while reading " + filename);
        }
    }

    /**
     * Saves the list of {@code Car} objects to the file {@code cars.txt}.
     */
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
