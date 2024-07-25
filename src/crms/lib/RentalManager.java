/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crms.lib;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Manages car rentals.
 * <p>
 * This class provides functionalities to check car availability, rent cars,
 * remove rentals, and generate rental reports.
 * </p>
 *
 * @author Yuan Suarez
 */
public class RentalManager implements IReportGenerator<RentalReport> {

    private Database<Rental> database;

    /**
     * Constructs a {@code RentalManager} with the specified rental database.
     *
     * @param database the database containing rental information
     */
    public RentalManager(Database<Rental> database) {
        this.database = database;
    }

    /**
     * Gets the rental database.
     *
     * @return the rental database
     */
    public Database<Rental> getDatabase() {
        return database;
    }

    /**
     * Checks if the specified car is available for rental during the given
     * dates.
     *
     * @param car the car to check.
     * @param startDate the start date of the rental period.
     * @param endDate the end date of the rental period.
     * @return {@code true} if the car is available, {@code false} otherwise.
     */
    public boolean isCarAvailable(Car car, LocalDate startDate, LocalDate endDate) {
        if (car == null) {
            return false;
        }
        for (Rental rental : database.dataList) {
            if ((rental.getCar().getId() == null ? car.getId() == null : rental.getCar().getId().equals(car.getId()))
                    && (startDate.isBefore(rental.getEndDate()) && endDate.isAfter(rental.getStartDate()))) {
                return false;
            }
        }
        return true;
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
        for (Rental rental : database.dataList) {
            if ((rental.getCar().getId() == null ? car.getId() == null : rental.getCar().getId().equals(car.getId()))
                    && ((LocalDate.now().isBefore(rental.getEndDate()) || LocalDate.now().isEqual(rental.getEndDate()))
                    && (LocalDate.now().isAfter(rental.getStartDate()) || LocalDate.now().isEqual(rental.getStartDate())))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Attempts to rent a car for the specified period.
     *
     * @param car the car to rent.
     * @param startDate the start date of the rental period.
     * @param endDate the end date of the rental period.
     * @return {@code true} if the car was successfully rented, {@code false}
     * otherwise.
     */
    public boolean tryRentCar(Car car, LocalDate startDate, LocalDate endDate) {
        if (isCarAvailable(car, startDate, endDate)) {
            Rental rental = new Rental(car, startDate, endDate);
            System.out.println("Added rental");
            database.dataList.add(rental);
            return true;
        }
        return false;
    }

    /**
     * Attempts to remove a rental from the list.
     *
     * @param rental the rental to remove.
     * @return {@code true} if the rental was successfully removed,
     * {@code false} otherwise.
     */
    public boolean tryRemoveRental(Rental rental) {
        for (Rental r : database.dataList) {
            if (r.getId() == null ? rental.getId() == null : r.getId().equals(rental.getId())) {
                database.dataList.remove(r);
                return true;
            }
        }
        return false;
    }

    /**
     * Generates a report of all rentals.
     *
     * @return an {@code ArrayList} of {@code RentalReport} objects.
     */
    public ArrayList<RentalReport> generateReport() {
        var newList = new ArrayList<RentalReport>();
        for (Rental rental : database.dataList) {
            newList.add(new RentalReport(rental));
        }
        return newList;
    }
}
