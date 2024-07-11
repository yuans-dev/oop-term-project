/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crms.lib;

import java.util.ArrayList;

/**
 *
 * @author u1ben
 */
public class CarInventory {
    private static CarInventory instance;
    private final ArrayList <Car> cars;
    
    private CarInventory(){
        cars = new ArrayList<>();
    }
    /**
     * Singleton implementation of CarInventory
     * @return Instance of <code>CarInventory</code>
     */
    public static CarInventory getInstance(){
        if(instance == null){
            System.out.println("Creating new instance");
            instance = new CarInventory();
        }
        return instance;
    }
    public boolean isIdAvailable(int id){
        for(Car car : cars){
            if(car.getId() == id) return false;
        }
        return true;
    }
    public void addCar(Car car){
        cars.add(car);
    }
    public Car getCarById(int id){
        for(Car car:cars){
            if(car.getId() == id) return car;
        }
        return null;
    }
}
