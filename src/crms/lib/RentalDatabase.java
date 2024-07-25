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
public class RentalDatabase extends Database<Rental> {

    private final String filename = "rentals.txt";
    private static RentalDatabase instance;

    /**
     * Private constructor to prevent instantiation. Initializes the rentals
     * list.
     */
    private RentalDatabase() {
        dataList = new ArrayList<>();
    }

    /**
     * Returns the singleton instance of {@code RentalService}. If the instance
     * does not exist, it is created and the rentals are fetched from disk.
     *
     * @return the singleton instance of {@code RentalService}.
     */
    public static RentalDatabase getInstance() {
        if (instance == null) {
            instance = new RentalDatabase();
            instance.fetchFromDisk();
        }
        return instance;
    }

    /**
     * Retrieves a rental by its ID.
     *
     * @param id the ID of the rental.
     * @return the {@code Rental} with the specified ID, or {@code null} if not
     * found.
     */
    public Rental getItemById(String id) {
        for (Rental r : dataList) {
            if (r.getId() == null ? id == null : r.getId().equals(id)) {
                return r;
            }
        }
        return null;
    }

    /**
     * Fetches the recorded {@code Rental} objects from the file
     * {@code rentals.txt}.
     *
     */
    public void fetchFromDisk() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            while (reader.ready()) {
                String text = reader.readLine();
                String[] lineComponents = text.split("###");
                var carDatabase = CarDatabase.getInstance();
                try {
                    Car car = carDatabase.getItemById(lineComponents[2]);
                    if (car == null) {
                        return;
                    }
                    dataList.add(new Rental(car, LocalDate
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
                for (Rental rental : dataList) {
                    toWrite.append(rental.getStartDate().toString())
                            .append("###")
                            .append(rental.getEndDate().toString())
                            .append("###")
                            .append(rental.getCar().getId()).append("\n");
                }
                fileWriter.write(toWrite.toString());
            }
        } catch (IOException e) {
            System.out.println("An exception has occured while saving to disk.");
        }
    }
}
