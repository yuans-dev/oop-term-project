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
import java.time.Period;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author u1ben
 */
public class RentalService {
    private final String filename = "rentals.txt";
    private static RentalService instance;
    public ArrayList<Rental> rentals;
    private RentalService(){
        rentals = new ArrayList<>();
    }
    /**
     * Singleton implementation of RentalService
     * @return Instance of <code>RentalService</code>
     */
    public static RentalService getInstance(){
        if(instance == null){
            instance = new RentalService();
            instance.fetchFromDisk();
        }
        return instance;
    }
    /**
     * Checks if car is available for rental during the given date
     * @param id
     * @param startDate
     * @param endDate
     * @return <code>true</code> if car is available
     */
    public boolean isCarAvailable(Car car, LocalDate startDate, LocalDate endDate) {
        if(car == null){
            return false;
        }
        for (Rental rental : rentals) {
            if (rental.getCar().getId() == car.getId() &&
                (startDate.isBefore(rental.getEndDate()) && endDate.isAfter(rental.getStartDate()))) {
                return false;
            }
        }
        return true;
    }
    public boolean tryRentCar(Car car, LocalDate startDate, LocalDate endDate) {
        System.out.println("Renting car " + car.getBrand());
        if (isCarAvailable(car, startDate, endDate)) {
            Rental rental = new Rental(car, startDate, endDate);
            rentals.add(rental);
            return true;
        }
        return false;
    }
    public void fetchFromDisk(){
        try{
            var carInventory = CarInventory.getInstance();
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            while(reader.ready()){
                String text = reader.readLine();
                String[] lineComponents = text.split("###");
                System.out.println(text);
                rentals.add(
                        new Rental(
                                carInventory.getCarById(Integer.parseInt(lineComponents[2])),
                                LocalDate.parse(lineComponents[0]),
                                LocalDate.parse(lineComponents[1])
                        ));
            }
        }catch(IOException | NumberFormatException e){
            System.out.println("An exception has occured while reading " + filename);
        }
    }
    public void saveToDisk(){
        try{
            try (FileWriter fileWriter = new FileWriter(filename)) {
                String toWrite = "";
                for(Rental rental : rentals){    
                    toWrite += rental.getStartDate().toString() + "###" + rental.getEndDate().toString() + "###" + rental.getCar().getId() + "\n";
                }
                System.out.println(toWrite);
                fileWriter.write(toWrite);
            }
        }catch(IOException e){
            System.out.println("An exception has occured while saving to disk.");
        }
    }
}
