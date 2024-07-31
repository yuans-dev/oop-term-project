/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crms.lib;

/**
 * Represents a unit of a car in the system.
 * <p>
 * This class contains information about the car, including its brand, model,
 * description, price, and a unique ID.
 * </p>
 *
 * @author Yuan Suarez
 * @version 1.0
 */
public class Car {

    private String description;
    private String brand;
    private String model;
    private double price;
    private String id;

    public Car() {
        brand = "Unknown brand";
        model = "Unknown model";
        price = 0;
        id = "0000";
        description = "No description";
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets the price for the {@code Car}.
     *
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the price of the {@code Car}.
     *
     * @return the price of the car
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Gets the unique ID of the {@code Car}.
     *
     * @return the ID of the car
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the description of the {@code Car}.
     *
     * @return the description of the car
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the description of the {@code Car}.
     *
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the brand of the {@code Car}.
     *
     * @return the brand of the car
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Gets the model of the {@code Car}.
     *
     * @return the model of the car
     */
    public String getModel() {
        return model;
    }
}
