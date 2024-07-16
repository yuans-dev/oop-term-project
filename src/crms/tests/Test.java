/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crms.tests;
import crms.lib.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

/**
 *
 * @author u1ben
 */
public class Test {
    public static void main(String[] args) {
        var carInventory = CarInventory.getInstance();
        
        System.out.println("\nReport\n------------------------------");
        for(ReportViewModel report: carInventory.generateReport()){
            System.out.println(report.getCar().getId()+ "       \t" + report.getCar().getBrand() + "       \t"
            + report.getCar().getModel()+"       \t"
            + report.getCar().getDescription() + "            \t"
            + report.getCar().getPrice() + "\t"
            + "Available? " + report.isAvailable());
        }
    }
}
