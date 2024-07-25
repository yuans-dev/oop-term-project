/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crms.lib;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Manages car inventory and rentals.
 * <p>
 * This class provides functionalities to add and remove cars from inventory,
 * check car availability, and generate reports about the cars.
 * </p>
 *
 * @author Yuan Suarez
 */
public class CarManager implements IReportGenerator<CarReport> {

    private Database<Car> carDatabase;
    private Database<Rental> rentalDatabase;

    /**
     * Constructs a {@code CarManager} with the specified car and rental
     * databases.
     *
     * @param carDatabase the database containing car information
     * @param rentalDatabase the database containing rental information
     */
    public CarManager(Database<Car> carDatabase, Database<Rental> rentalDatabase) {
        this.carDatabase = carDatabase;
        this.rentalDatabase = rentalDatabase;
    }

    /**
     * Gets the car database.
     *
     * @return the car database
     */
    public Database<Car> getDatabase() {
        return carDatabase;
    }

    /**
     * Adds a {@code Car} to the inventory if its ID is unique.
     *
     * @param car The {@code Car} object to be added.
     * @return True if the car was added successfully, false otherwise.
     */
    public boolean tryAddCar(Car car) {
        for (Car c : carDatabase.dataList) {
            if (c.getId() == null ? car.getId() == null : c.getId().equals(car.getId())) {
                return false;
            }
        }
        carDatabase.dataList.add(car);
        return true;
    }

    /**
     * Removes a {@code Car} from the inventory based on its unique ID.
     *
     * @param car The {@code Car} object to be removed
     * @return true if the car was removed successfully, false otherwise.
     */
    public boolean tryRemoveCar(Car car) {
        for (Car c : carDatabase.dataList) {
            if (c.getId() == null ? car.getId() == null : c.getId().equals(car.getId())) {
                carDatabase.dataList.remove(c);
                return true;
            }
        }
        return false;
    }

    /**
     * Generates a report that shows the properties and availability of each
     * {@code Car} object.
     *
     * @return an {@code ArrayList} of {@code CarReport} objects.
     */
    public ArrayList<CarReport> generateReport() {
        var reports = new ArrayList<CarReport>();
        for (Car car : carDatabase.dataList) {
            var report = new CarReport(car, isCarAvailableNow(car));
            reports.add(report);
        }
        return reports;
    }

    /**
     * Checks if the specified car is currently available for rental.
     *
     * @param car the car to check.
     * @return {@code true} if the car is available, {@code false} otherwise.
     */
    public boolean isCarAvailableNow(Car car) {
        if (car == null) {
            return false;
        }
        for (Rental rental : rentalDatabase.dataList) {
            if ((rental.getCar().getId() == null ? car.getId() == null : rental.getCar().getId().equals(car.getId()))
                    && ((LocalDate.now().isBefore(rental.getEndDate()) || LocalDate.now().isEqual(rental.getEndDate()))
                    && (LocalDate.now().isAfter(rental.getStartDate()) || LocalDate.now().isEqual(rental.getStartDate())))) {
                return false;
            }
        }
        return true;
    }
}
