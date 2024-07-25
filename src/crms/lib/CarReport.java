/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crms.lib;

import java.util.Objects;

/**
 * Represents a report item for a {@code Car}.
 * <p>
 * This class contains information about a car and its availability status.
 * </p>
 *
 * @author Yuan Suarez
 *
 */
public class CarReport {

    private final Car car;
    private boolean isAvailable;

    /**
     * Constructs a {@code CarReport} object with the specified car and
     * availability status.
     *
     * @param car the {@code Car} associated with the report
     * @param isAvailable {@code true} if the car is available, {@code false}
     * otherwise
     */
    public CarReport(Car car, boolean isAvailable) {
        this.car = car;
        this.isAvailable = isAvailable;
    }

    /**
     * Gets the {@code Car} object associated with this report.
     *
     * @return the {@code Car} associated with the report
     */
    public Car getCar() {
        return this.car;
    }

    /**
     * Gets the availability status of the car.
     *
     * @return {@code true} if the car is available, {@code false} otherwise
     */
    public boolean isAvailable() {
        return this.isAvailable;
    }

    /**
     * Compares this {@code CarReport} to the specified object for equality.
     * <p>
     * Two {@code CarReport} objects are considered equal if they have the same
     * {@code Car} ID.
     * </p>
     *
     * @param o the object to compare with
     * @return {@code true} if this {@code CarReport} is equal to the specified
     * object, {@code false} otherwise
     */
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

    /**
     * Returns a hash code value for this {@code CarReport}.
     * <p>
     * The hash code is based on the {@code Car} object.
     * </p>
     *
     * @return the hash code value for this {@code CarReport}
     */
    @Override
    public int hashCode() {
        return Objects.hash(car.getId());
    }
}
