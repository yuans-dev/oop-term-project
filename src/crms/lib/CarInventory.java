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
import java.util.function.Predicate;

/**
 * CarInventory class is responsible for getting the recorded <code>Car</code>
 * objects in the local database and several operations related to it.
 *
 * @author Yuan Suarez
 */
public class CarInventory {

    private final String filename = "cars.txt";
    private static CarInventory instance;
    private final ArrayList<Car> cars;

    private CarInventory() {
        cars = new ArrayList<>();
    }

    /**
     * Singleton implementation of CarInventory
     *
     * @return Instance of <code>CarInventory</code>
     */
    public static CarInventory getInstance() {
        if (instance == null) {
            instance = new CarInventory();
            instance.fetchFromDisk();
        }
        return instance;
    }

    /**
     * Adds <code>Car</code> to <code>cars</code> if ID property is unique
     *
     * @param car
     * @return True if successful.
     */
    public boolean tryAddCar(Car car) {
        for (Car c : cars) {
            if (c.getId() == car.getId()) {
                return false;
            }
        }
        cars.add(car);
        return true;
    }

    /**
     * Removes <code>Car</code> from <code>cars</code> based on its unique ID
     *
     * @param car
     * @return True if successful.
     */
    public boolean tryRemoveCar(Car car) {
        for (Car c : cars) {
            if (c.getId() == car.getId()) {
                cars.remove(c);
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param id
     * @return
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
     *
     * @return
     */
    /**
     *
     * @param rentalService
     * @return
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
     * Generates report and filters results based on provided function.
     *
     * @param rentalService
     * @param predicate
     * @return
     */
    public ArrayList<CarReport> generateReport(RentalService rentalService, Predicate<Car> predicate) {
        var reports = new ArrayList<CarReport>();
        for (Car car : cars) {
            if (predicate.test(car)) {
                var report = new CarReport(car, rentalService.isCarAvailableNow(car));
                reports.add(report);
            }
        }
        return reports;
    }

    /**
     *
     */
    public void fetchFromDisk() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));

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
            System.out.println("An exception has occured while reading " + filename);
        }
    }

    /**
     *
     */
    public void saveToDisk() {

        try {
            try (FileWriter fileWriter = new FileWriter(filename)) {
                String toWrite = "";
                for (Car car : cars) {
                    toWrite += car.getId() + "###" + car.getBrand() + "###" + car.getModel() + "###" + car.getDescription() + "###" + car.getPrice() + "\n";
                }
                fileWriter.write(toWrite);
            }
        } catch (IOException e) {
            System.out.println("An exception has occured while saving to disk.");
        }
    }
}
