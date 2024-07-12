/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crms.lib;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

/**
 *
 * @author u1ben
 */
public class RentalService {
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
        }
        return instance;
    }
    /**
     * Checks if car is available for rental during the given date
     * @param car
     * @param startDate
     * @param endDate
     * @return <code>true</code> if car is available
     */
    public boolean isCarAvailable(Car car, LocalDate startDate, LocalDate endDate) {
        for (Rental rental : rentals) {
            if (rental.getCar().equals(car) && 
                (startDate.isBefore(rental.getEndDate()) && endDate.isAfter(rental.getStartDate()))) {
                return false;
            }
        }
        return true;
    }
    public boolean rentCar(Car car, LocalDate startDate, LocalDate endDate) {
        System.out.println("Renting car " + car.getBrand());
        if (isCarAvailable(car, startDate, endDate)) {
            Rental rental = new Rental(car, startDate, endDate);
            rentals.add(rental);
            return true;
        }
        return false;
    }
    public boolean rentCar(Car car, LocalDate startDate, Period period) {
        LocalDate endDate = startDate.plusYears(period.getYears()).plusMonths(period.getMonths()).plusDays(period.getDays());
        if (isCarAvailable(car, startDate, endDate)) {
            Rental rental = new Rental(car, startDate, endDate);
            rentals.add(rental);
            return true;
        }
        return false;
    }
}
