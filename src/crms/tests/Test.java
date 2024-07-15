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
        var rentalService = RentalService.getInstance();

        //Adding cars and rentals
        for(int i =0; i < 30; i++){
            var car = new Car("SomeBrand","SomeModel","Some Description",3000);
            boolean success;
            
            //Code for adding cars to ensure uniqueness of id
            do{
               success = carInventory.tryAddCar(car);
               if(!success){
                   car.incrementId();
               }
            }while(!success);
            
            //Code for renting
            rentalService.tryRentCar(car, LocalDate.now(), LocalDate.of(2024, Month.DECEMBER, 1));
        }
        
        //Check if car is available
        System.out.println(carInventory.getCarById(511754212));
        System.out.println(rentalService.isCarAvailable(carInventory.getCarById(511754212), LocalDate.now(), LocalDate.of(2024, Month.AUGUST, 15)));
       
    }
}
