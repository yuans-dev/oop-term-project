/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crms.lib;

/**
 *
 * @author u1ben
 */
public class ReportViewModel {
    private final Car car;
    private final boolean isAvailable;
    public ReportViewModel(Car car, boolean isAvailable){
        this.car = car;
        this.isAvailable = isAvailable;
    }
    public Car getCar(){
        return this.car;
    }
    public boolean isAvailable(){
        return this.isAvailable;
    }
}
