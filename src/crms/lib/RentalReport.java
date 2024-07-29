/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crms.lib;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 * Represents a report for a rental, including information about the rental
 * duration and its current status (active or inactive).
 *
 * <p>
 * This class is immutable and contains methods for formatting the rental period
 * and determining the rental status.</p>
 *
 * @author Yuan Suarez
 */
public class RentalReport {

    private final Rental rental;
    private final String duration;
    private final RentalStatus status;

    /**
     * Constructs a RentalReport with the specified rental. The duration is
     * calculated based on the rental period, and the status is determined based
     * on the current date and the rental's end date.
     *
     * @param rental the rental for which the report is generated
     */
    public RentalReport(Rental rental) {
        this.rental = rental;

        this.status = (LocalDate.now().isBefore(rental.getEndDate())
                || LocalDate.now().equals(rental.getEndDate()))
                && (LocalDate.now().isAfter(rental.getStartDate())
                || LocalDate.now().equals(rental.getStartDate()))
                ? RentalStatus.Active : RentalStatus.Inactive;
        this.duration = status == RentalStatus.Inactive
                ? formatPeriod(rental.getRentalPeriod())
                : formatPeriod(rental.getRentalPeriod()) + " (" + formatPeriod(Period.between(LocalDate.now(), rental.getEndDate())) + " remaining)";
    }

    /**
     * Formats a Period object into a human-readable string. The format includes
     * years, months, and days, as applicable.
     *
     * @param period the period to format
     * @return a formatted string representing the period
     */
    private String formatPeriod(Period period) {
        StringBuilder formattedPeriod = new StringBuilder();

        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();

        if (years > 0) {
            formattedPeriod.append(years).append(" year");
            if (years > 1) {
                formattedPeriod.append("s");
            }
            if (months > 0 || days > 0) {
                formattedPeriod.append(", ");
            }
        }

        if (months > 0) {
            formattedPeriod.append(months).append(" month");
            if (months > 1) {
                formattedPeriod.append("s");
            }
            if (days > 0) {
                formattedPeriod.append(", ");
            }
        }

        if (days > 0) {
            formattedPeriod.append(days).append(" day");
            if (days > 1) {
                formattedPeriod.append("s");
            }
        }

        return formattedPeriod.toString();
    }

    /**
     * Returns the rental associated with this report.
     *
     * @return the rental
     */
    public Rental getRental() {
        return rental;
    }

    /**
     * Returns the formatted duration of the rental.
     *
     * @return the rental duration as a formatted string
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Returns the current status of the rental.
     *
     * @return the rental status
     */
    public RentalStatus getStatus() {
        return status;
    }

    /**
     * Indicates whether some other object is "equal to" this one. Two
     * RentalReports are considered equal if they have the same rental ID.
     *
     * @param o the reference object with which to compare
     * @return true if this object is the same as the obj argument; false
     * otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return (rental.getId() == null ? rental.getId() == null : rental.getId().equals(rental.getId()));
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.rental);
        return hash;
    }

    /**
     * Enum representing the rental status.
     */
    public enum RentalStatus {
        Active, Inactive
    }
}
