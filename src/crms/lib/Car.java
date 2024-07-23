/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crms.lib;

import java.util.Random;

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
    private final String brand;
    private final String model;
    private double price;
    private final String id;

    /**
     * Constructs a {@code Car} object with the specified brand, model,
     * description, and price.
     * <p>
     * The ID is automatically generated for new car objects.
     * </p>
     *
     * @param brand the brand of the car
     * @param model the model of the car
     * @param description a description of the car
     * @param price the price of the car
     */
    public Car(String brand, String model, String description, double price) {
        this.id = generateRandomId();
        this.description = description;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    /**
     * Constructs a {@code Car} object with the specified ID, brand, model,
     * description, and price.
     * <p>
     * This constructor is used when the car ID is known, such as when loading
     * from an existing database.
     * </p>
     *
     * @param id the unique ID of the car
     * @param brand the brand of the car
     * @param model the model of the car
     * @param description a description of the car
     * @param price the price of the car
     */
    public Car(String id, String brand, String model, String description, double price) {
        this.id = id;
        this.description = description.trim();
        this.brand = brand.trim();
        this.model = model.trim();
        this.price = price;
    }

    /**
     * Generates a random 4-digit hexadecimal number as an ID for the
     * {@code Car} object.
     *
     * @return a {@code String} representing a 4-digit hexadecimal number
     */
    private String generateRandomId() {
        Random random = new Random();
        int randomNumber = random.nextInt(0x10000);
        return String.format("%04X", randomNumber);
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
