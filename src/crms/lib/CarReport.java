/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crms.lib;

import java.util.Objects;

/**
 * Class representing a report item.
 *
 * @author Yuan Suarez
 */
public class CarReport implements IReport {

    private final Car car;
    private final boolean isAvailable;

    /**
     *
     * @param car
     * @param isAvailable
     */
    public CarReport(Car car, boolean isAvailable) {
        this.car = car;
        this.isAvailable = isAvailable;
    }

    /**
     *
     * @return
     */
    public Car getCar() {
        return this.car;
    }

    /**
     *
     * @return
     */
    public boolean isAvailable() {
        return this.isAvailable;
    }

    @Override
    public String getId() {
        return car.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarReport c = (CarReport) o;
        return (getId() == null ? getId() == null : getId().equals(getId()));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.car);
        return hash;
    }
}
