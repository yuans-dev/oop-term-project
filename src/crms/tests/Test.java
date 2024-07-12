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
        CarInventory.getInstance().fetchFromDisk();

        CarInventory.getInstance().addCar(new Car(3,"Toyota","Corolla","New",3478));
        RentalService.getInstance().rentCar(CarInventory.getInstance().getCarById(3),LocalDate.now(),LocalDate.of(2025, Month.MARCH, 3));
        CarInventory.getInstance().saveToDisk();
    }
}
