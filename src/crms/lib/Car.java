/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crms.lib;

/**
 * Object describing a Car unit
 * @author      Yuan Suarez
 * 
 */
public class Car {
    /**
     * Description of the car
     */
    private String description;
    private String brand;
    private String model;
    private double price;
    private int id;

    
    /**
     * 
     * 
     * @param brand brand
     * @param model model
     * @param description description
     * @param price price
     */
    public Car(String brand, String model, String description, double price){
        this.id = this.hashCode();
        this.description = description;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
    public Car(int id, String brand, String model, String description, double price){
        this.id = id;
        this.description = description;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public double getPrice(){
        return this.price;
    }
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
    public void incrementId(){
        this.id++;
    }
}
