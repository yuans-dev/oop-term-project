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
 * RentalService class is responsible for getting the recorded
 * <code>Rental</code> objects in the local database and several operations
 * related to it.
 *
 * @author Yuan Suarez
 */
public class RentalService {

    private final String filename = "rentals.txt";
    private static RentalService instance;

    /**
     *
     */
    public ArrayList<Rental> rentals;

    private RentalService() {
        rentals = new ArrayList<>();
    }

    /**
     * Singleton implementation of RentalService
     *
     * @param carInventory <code>RentalService</code> is dependent on
     * <code>CarInventory</code>.
     * @return Instance of <code>RentalService</code>
     */
    public static RentalService getInstance(CarInventory carInventory) {
        if (instance == null) {
            instance = new RentalService();
            instance.fetchFromDisk(carInventory);
        }
        return instance;
    }

    /**
     * Checks if car is available for rental during the given date
     *
     * @param car
     * @param startDate
     * @param endDate
     * @return <code>true</code> if car is available
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

    public ArrayList<RentalReport> generateReport() {
        var newList = new ArrayList<RentalReport>();//create new arraylist so rentals cannot be modified directly
        for (Rental rental : rentals) {
            newList.add(new RentalReport(rental));
        }
        return newList;
    }

    /**
     *
     * @param car
     * @return True if <code>Car car</code> is available.
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
     *
     * @param car
     * @param startDate
     * @param endDate
     * @return True if successful.
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

    public boolean tryRemoveRental(Rental rental) {
        for (Rental r : rentals) {
            if (r.getId() == null ? rental.getId() == null : r.getId().equals(rental.getId())) {
                rentals.remove(r);
                return true;
            }
        }
        return false;
    }

    public Rental getRentalById(String id) {
        for (Rental r : rentals) {
            if (r.getId() == null ? id == null : r.getId().equals(id)) {
                return r;
            }
        }
        return null;
    }

    /**
     * Gets the number of times a Car has been rented by looking at past
     * rentals.
     *
     * @param car
     * @return <code>int</code> representing the number of times a Car has been
     * rented.
     */
    public int getTimesRented(Car car) {
        var times = 0;
        for (Rental rental : rentals) {
            if (rental.getCar().getId() == null ? car.getId() == null : rental.getCar().getId().equals(car.getId())) {
                times++;
            }
        }
        return times;
    }

    /**
     * Fetches the recorded <code>Car</code> objects within cars.txt.
     *
     * @param carInventory
     */
    public void fetchFromDisk(CarInventory carInventory) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            while (reader.ready()) {
                String text = reader.readLine();
                String[] lineComponents = text.split("###");
                try {
                    var car = carInventory.getCarById(lineComponents[2]);
                    if (car == null) {
                        return;
                    }
                    rentals.add(new Rental(car, LocalDate
                            .parse(lineComponents[0]),
                            LocalDate.parse(lineComponents[1])
                    )
                    );
                } catch (Exception e) {
                    System.out.println("No car unit associated to rental: " + lineComponents[2]);
                }

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
                for (Rental rental : rentals) {
                    toWrite += rental.getStartDate().toString() + "###" + rental.getEndDate().toString() + "###" + rental.getCar().getId() + "\n";
                }
                fileWriter.write(toWrite);
            }
        } catch (IOException e) {
            System.out.println("An exception has occured while saving to disk.");
        }
    }
}
