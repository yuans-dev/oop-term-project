/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crms.lib;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * Represents a rental transaction for a {@code Car}.
 * <p>
 * This class contains information about the rental period, the car being
 * rented, and a unique rental ID.
 * </p>
 *
 * @author Yuan Suarez
 *
 */
public class Rental {

    private final String id;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final Car car;

    /**
     * Creates a new Rental object with the specified properties.
     * <p>
     * The rental ID is generated based on a preset format: "1" + start date
     * (MMDDYY) + car ID.
     * </p>
     *
     * @param car the {@code Car} being rented
     * @param start the start date of the rental period
     * @param end the end date of the rental period
     */
    public Rental(Car car, LocalDate start, LocalDate end) {
        this.id = "1" + start.format(DateTimeFormatter.ofPattern("MMddyy")) + car.getId();
        this.car = car;
        this.startDate = start;
        this.endDate = end;
    }

    /**
     * Checks if the rental is available.
     * <p>
     * A rental is considered available if the start date is {@code null}.
     * </p>
     *
     * @return {@code true} if the rental is available, {@code false} otherwise
     */
    public boolean isAvailable() {
        return startDate == null;
    }

    /**
     * Calculates the rental period.
     * <p>
     * The rental period is the duration between the start date and the end
     * date. If the rental is available (start date is {@code null}), this
     * method returns {@code null}.
     * </p>
     *
     * @return a {@code Period} object representing the duration between the
     * start and end dates, or {@code null} if the rental is available
     */
    public Period getRentalPeriod() {
        return isAvailable() ? null : Period.between(startDate, endDate);
    }

    /**
     * Gets the car being rented.
     *
     * @return the {@code Car} object associated with this rental
     */
    public Car getCar() {
        return car;
    }

    /**
     * Gets the unique ID of the rental.
     *
     * @return the rental ID
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the start date of the rental period.
     *
     * @return the start date
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Gets the end date of the rental period.
     *
     * @return the end date
     */
    public LocalDate getEndDate() {
        return endDate;
    }
}
