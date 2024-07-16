/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crms.lib;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
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
            instance = new CarInventory();
            instance.fetchFromDisk();
        }
        return instance;
    }
    /**
     * Adds car to list if id property is unique
     * @param car
     * @return true if successful in adding
     */
    public boolean tryAddCar(Car car){
        for(Car c:cars){
            if(c.getId()==car.getId()){
                return false;
            }
        }
        cars.add(car);
        return true;
    }
    public Car getCarById(int id){
        for(Car car:cars){
            if(car.getId() == id) return car;
        }
        return null;
    }
    public int generateUniqueId(){
        int uniqueId = this.hashCode();
        for(Car c: cars){
            while(uniqueId == c.getId()){
                uniqueId++;
            }
        }
        return uniqueId;
    }
    public ArrayList<ReportViewModel> generateReport(){
        var rentalService = RentalService.getInstance();
        var reports = new ArrayList<ReportViewModel>();
        for(Car car: cars){
            var report = new ReportViewModel(car, rentalService.isCarAvailableNow(car));
            reports.add(report);
        }
        return reports;
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
        }catch(IOException | NumberFormatException e){
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
                fileWriter.write(toWrite);
            }
        }catch(IOException e){
            System.out.println("An exception has occured while saving to disk.");
        }
    }
}
