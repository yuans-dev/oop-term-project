package crms.lib;

import java.util.Objects;

public class CarReport {

    private final Car car;
    private final boolean isAvailable;

    public CarReport(Car car, boolean isAvailable) {
        this.car = car;
        this.isAvailable = isAvailable;
    }

    public Car getCar() {
        return this.car;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarReport other = (CarReport) o;
        return Objects.equals(car.getId(), other.car.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(car.getId());
    }
}
