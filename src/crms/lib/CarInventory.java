/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crms.lib;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.util.ArrayList;

/**
 *
 * @author u1ben
 */
public class CarInventory {
    private final String filename = "cars.txt";
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
    public void fetchFromDisk(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            while(reader.ready()){
                String text = reader.readLine();
                String[] lineComponents = text.split("###");
                cars.add(
                        new Car(
                                Integer.parseInt(lineComponents[0]),//id
                                lineComponents[1],//brand
                                lineComponents[2],//model
                                lineComponents[3],//description
                                Double.parseDouble(lineComponents[4])//price
                        ));
            }
        }catch(Exception e){
            System.out.println("An exception has occured while reading " + filename);
        }
    }
    public void saveToDisk(){
        try{
            try (FileWriter fileWriter = new FileWriter(filename)) {
                String toWrite = "";
                for(Car car : cars){
                    toWrite += car.getId() + "###" + car.getBrand() + "###" + car.getModel() + "###" + car.getDescription() + "###" + car.getPrice() + "\n";
                }
                System.out.println(toWrite);
                fileWriter.write(toWrite);
            }
        }catch(Exception e){
            System.out.println("An exception has occured while saving to disk.");
        }
    }
}
