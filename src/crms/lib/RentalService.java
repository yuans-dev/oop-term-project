/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crms.lib;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The {@code RentalService} class is responsible for managing rental operations
 * including fetching recorded {@code Rental} objects from the local database,
 * checking car availability, and generating rental reports.
 *
 * <p>
 * This class follows the singleton pattern to ensure that only one instance of
 * {@code RentalService} is created.</p>
 *
 * @author Yuan Suarez
 */
public class RentalService {

    private final String filename = "rentals.txt";
    private static RentalService instance;

    /**
     * The list of rentals managed by the service.
     */
    public ArrayList<Rental> rentals;

    /**
     * Private constructor to prevent instantiation. Initializes the rentals
     * list.
     */
    private RentalService() {
        rentals = new ArrayList<>();
    }

    /**
     * Returns the singleton instance of {@code RentalService}. If the instance
     * does not exist, it is created and the rentals are fetched from disk.
     *
     * @param carInventory the {@code CarInventory} instance required to fetch
     * associated {@code Car} objects.
     * @return the singleton instance of {@code RentalService}.
     */
    public static RentalService getInstance(CarInventory carInventory) {
        if (instance == null) {
            instance = new RentalService();
            instance.fetchFromDisk(carInventory);
        }
        return instance;
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
        for (Rental rental : rentals) {
            if ((rental.getCar().getId() == null ? car.getId() == null : rental.getCar().getId().equals(car.getId()))
                    && (startDate.isBefore(rental.getEndDate()) && endDate.isAfter(rental.getStartDate()))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Generates a report of all rentals.
     *
     * @return an {@code ArrayList} of {@code RentalReport} objects.
     */
    public ArrayList<RentalReport> generateReport() {
        var newList = new ArrayList<RentalReport>();
        for (Rental rental : rentals) {
            newList.add(new RentalReport(rental));
        }
        return newList;
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
        for (Rental rental : rentals) {
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
            rentals.add(rental);
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
        for (Rental r : rentals) {
            if (r.getId() == null ? rental.getId() == null : r.getId().equals(rental.getId())) {
                rentals.remove(r);
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves a rental by its ID.
     *
     * @param id the ID of the rental.
     * @return the {@code Rental} with the specified ID, or {@code null} if not
     * found.
     */
    public Rental getRentalById(String id) {
        for (Rental r : rentals) {
            if (r.getId() == null ? id == null : r.getId().equals(id)) {
                return r;
            }
        }
        return null;
    }

    /**
     * Gets the number of times a car has been rented.
     *
     * @param car the car to check.
     * @return the number of times the car has been rented.
     */
    public int getTimesRented(Car car) {
        int times = 0;
        for (Rental rental : rentals) {
            if (rental.getCar().getId() == null ? car.getId() == null : rental.getCar().getId().equals(car.getId())) {
                times++;
            }
        }
        return times;
    }

    /**
     * Fetches the recorded {@code Rental} objects from the file
     * {@code rentals.txt}.
     *
     * @param carInventory the {@code CarInventory} instance required to fetch
     * associated {@code Car} objects.
     */
    public void fetchFromDisk(CarInventory carInventory) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            while (reader.ready()) {
                String text = reader.readLine();
                String[] lineComponents = text.split("###");
                try {
                    Car car = carInventory.getCarById(lineComponents[2]);
                    if (car == null) {
                        return;
                    }
                    rentals.add(new Rental(car, LocalDate
                            .parse(lineComponents[0]),
                            LocalDate.parse(lineComponents[1])
                    )
                    );
                } catch (Exception e) {
                }

            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("An exception has occurred while reading " + filename);
        }
    }

    /**
     * Saves the list of {@code Rental} objects to the file {@code rentals.txt}.
     */
    public void saveToDisk() {
        try {
            try (FileWriter fileWriter = new FileWriter(filename)) {
                StringBuilder toWrite = new StringBuilder();
                for (Rental rental : rentals) {
                    toWrite.append(rental.getStartDate().toString())
                            .append("###")
                            .append(rental.getEndDate().toString())
                            .append("###")
                            .append(rental.getId()).append("\n");
                }
                fileWriter.write(toWrite.toString());
            }
        } catch (IOException e) {
            System.out.println("An exception has occured while saving to disk.");
        }
    }
}
