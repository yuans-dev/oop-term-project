/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crms.lib;

/**
 * Class representing a Car unit
 * @author      Yuan Suarez
 * 
 */
public class Car {
    /**
     * Description of the car
     */
    private String description;
    private final String brand;
    private final String model;
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

    /**
     *
     * @param id
     * @param brand
     * @param model
     * @param description
     * @param price
     */
    public Car(int id, String brand, String model, String description, double price){
        this.id = id;
        this.description = description;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(double price){
        this.price = price;
    }

    /**
     *
     * @return
     */
    public double getPrice(){
        return this.price;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return this.description;
    }
    /**
     * 
     * @param description 
     */
    public void setDescription(String description){
        this.description = description;
    }
    /**
     *
     * @return
     */
    public String getBrand() {
        return brand;
    }

    /**
     *
     * @return
     */
    public String getModel() {
        return model;
    }

    /**
     *
     */
    public void incrementId(){
        this.id++;
    }
}
