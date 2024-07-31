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
 * The {@code CarDatabase} class manages the collection of recorded {@code Car}
 * objects in the local database and performs various operations related to
 * them.
 *
 * <p>
 * It implements the singleton pattern to ensure only one instance of the class
 * exists.
 * </p>
 *
 * <p>
 * It provides methods to add, remove, and retrieve {@code Car} objects,
 * generate reports, and handle data persistence to a local file.
 * </p>
 *
 * @author Yuan Suarez
 */
public class CarDatabase extends Database<Car> {

    /**
     * The filename where the car data is stored.
     */
    private final String filename = "cars.txt";

    /**
     * The single instance of {@code CarDatabase}.
     */
    private static CarDatabase instance;

    /**
     * Private constructor to prevent instantiation. Initializes the
     * {@code cars} list.
     */
    private CarDatabase() {
        dataList = new ArrayList<>();
    }

    /**
     * Returns the singleton instance of {@code CarDatabase}. If the instance
     * does not exist, it is created and the cars are fetched from disk.
     *
     * @return the singleton instance of {@code CarDatabase}.
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
     * @param id the ID of the car to be retrieved.
     * @return the {@code Car} object with the specified ID, or {@code null} if
     * not found.
     */
    @Override
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
     */
    @Override
    public void fetchFromDisk() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while (reader.ready()) {
                String text = reader.readLine();
                String[] lineComponents = text.split("###");
                dataList.add(
                        new CarBuilder().setId(lineComponents[0])
                                .setBrand(lineComponents[1])
                                .setModel(lineComponents[2])
                                .setDescription(lineComponents[3])
                                .setPrice(Double.parseDouble(lineComponents[4])).getResult()
                );

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
