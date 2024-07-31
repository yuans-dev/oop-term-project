package crms.lib;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Rental {

    private final String id;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final Car car;

    public Rental(Car car, LocalDate start, LocalDate end) {
        this.id = "1" + start.format(DateTimeFormatter.ofPattern("MMddyy")) + car.getId();
        this.car = car;
        this.startDate = start;
        this.endDate = end;
    }

    public boolean isAvailable() {
        return startDate == null;
    }

    public Period getRentalPeriod() {
        return isAvailable() ? null : Period.between(startDate, endDate);
    }

    public Car getCar() {
        return car;
    }

    public String getId() {
        return id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
