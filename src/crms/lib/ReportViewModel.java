/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crms.lib;

/**
 * Class representing a report item.
 *
 * @author Yuan Suarez
 */
public class ReportViewModel {

    private final Car car;
    private final boolean isAvailable;

    /**
     *
     * @param car
     * @param isAvailable
     */
    public ReportViewModel(Car car, boolean isAvailable) {
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ReportViewModel c = (ReportViewModel) o;
        return getCar().getId() == c.getCar().getId();
    }
}
