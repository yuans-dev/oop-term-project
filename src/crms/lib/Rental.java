/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crms.lib;

import java.time.LocalDate;
import java.time.Period;

/**
 * Represents a rental transaction
 * @author u1ben
 */
public class Rental {
    private LocalDate startDate;
    private LocalDate endDate;
    private Car car;
    /**
     * Creates a default Rental object with preset properties
     * @param car
     * @param start
     * @param end
     */
    public Rental(Car car, LocalDate start, LocalDate end){
        this.car = car;
        startDate = start;
        endDate = end;
    }
    public boolean isAvailable(){
        return startDate == null;
    }
    /**
     * 
     * @return <code>Period</code> object representing the duration of time between rentStart and rentEnd
     */
    public Period getRentalPeriod(){
        return isAvailable() ? null : Period.between(startDate, endDate);
    }
    public Car getCar() {
        return car;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
}
