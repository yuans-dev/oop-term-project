/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crms.tests;
import crms.lib.*;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author u1ben
 */
public class Test {
    public static void main(String[] args) {
        Car a = new Car(1, "Honda", "Civic", "Car", 10000);
        Car b = new Car(2, "Toyota", "Vios", "Car", 10000);
        CarInventory.getInstance().addCar(a);
        CarInventory.getInstance().addCar(b);
        RentalService.getInstance().rentCar(CarInventory.getInstance().getCarById(1),LocalDate.now(),LocalDate.of(2025, Month.MARCH, 3));
        RentalService.getInstance().displayRentals();
    }
}
