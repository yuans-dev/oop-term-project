package crms.lib;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class RentalReport {

    private final Rental rental;
    private final String duration;
    private final RentalStatus status;

    public RentalReport(Rental rental) {
        this.rental = rental;
        this.duration = formatPeriod(rental.getRentalPeriod());
        this.status = (LocalDate.now().isBefore(rental.getEndDate())
                || LocalDate.now().equals(rental.getEndDate())) && (LocalDate.now().isAfter(rental.getStartDate()) || LocalDate.now().equals(rental.getStartDate())) ? RentalStatus.Active : RentalStatus.Inactive;
    }

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

    public Rental getRental() {
        return rental;
    }

    public String getDuration() {
        return duration;
    }

    public RentalStatus getStatus() {
        return status;
    }

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.rental);
        return hash;
    }

    public enum RentalStatus {
        Active, Inactive
    }
}
