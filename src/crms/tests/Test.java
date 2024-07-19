/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crms.tests;

import crms.lib.*;

/**
 *
 * @author u1ben
 */
public class Test {

    public static void main(String[] args) {
        var carInventory = CarInventory.getInstance();
        var rentalService = RentalService.getInstance(carInventory);
        System.out.println("\nReport\n------------------------------");
        for (Report report : carInventory.generateReport(rentalService, (c) -> c.getBrand().toLowerCase().contains("toyota"))) {
            var availability = report.isAvailable() ? "Available" : "Rented";
            System.out.println(report.getCar().getId() + "       \t" + report.getCar().getBrand() + "       \t"
                    + report.getCar().getModel() + "       \t"
                    + report.getCar().getDescription() + "            \t"
                    + report.getCar().getPrice() + "\t"
                    + availability);
        }
    }
}
