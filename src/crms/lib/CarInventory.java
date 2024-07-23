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
public class CarInventory {

    private final String filename = "cars.txt";
    private static CarInventory instance;
    private final ArrayList<Car> cars;

    /**
     * Private constructor to prevent instantiation. Initializes the
     * <code>cars</code> list.
     */
    private CarInventory() {
        cars = new ArrayList<>();
    }

    /**
     * Returns the singleton instance of {@code RentalService}. If the instance
     * does not exist, it is created and the cars are fetched from disk.
     *
     * @return the singleton instance of {@code CarInventory}.
     */
    public static CarInventory getInstance() {
        if (instance == null) {
            instance = new CarInventory();
            instance.fetchFromDisk();
        }
        return instance;
    }

    /**
     * Adds a {@code Car} to the inventory if its ID is unique.
     *
     * @param car The {@code Car} object to be added.
     * @return True if the car was added successfully, false otherwise.
     */
    public boolean tryAddCar(Car car) {
        for (Car c : cars) {
            if (c.getId() == null ? car.getId() == null : c.getId().equals(car.getId())) {
                return false;
            }
        }
        cars.add(car);
        return true;
    }

    /**
     * Removes a {@code Car} from the inventory based on its unique ID.
     *
     * @param car The {@code Car} object to be removed
     * @return true if the car was removed successfully, false otherwise.
     */
    public boolean tryRemoveCar(Car car) {
        for (Car c : cars) {
            if (c.getId() == null ? car.getId() == null : c.getId().equals(car.getId())) {
                cars.remove(c);
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves a {@code Car} object using the given ID.
     *
     * @param id the ID of the car to be retrieved
     * @return the {@code Car} object with the specified ID, or null if not
     * found
     */
    public Car getCarById(String id) {
        for (Car car : cars) {
            if (car.getId() == null ? id == null : car.getId().equals(id)) {
                return car;
            }
        }
        return null;
    }

    /**
     * Generates a report that shows the properties and availability of each
     * {@code Car} object.
     *
     * @param rentalService The {@code RentalService} instance required to check
     * the availability of each {@code Car} object.
     * @return an {@code ArrayList} of {@code CarReport} objects.
     */
    public ArrayList<CarReport> generateReport(RentalService rentalService) {
        var reports = new ArrayList<CarReport>();
        for (Car car : cars) {
            var report = new CarReport(car, rentalService.isCarAvailableNow(car));
            reports.add(report);
        }
        return reports;
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
                cars.add(
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
            for (Car car : cars) {
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
