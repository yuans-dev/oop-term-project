/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crms.lib;

import java.util.Random;

/**
 * Class representing a Car unit
 *
 * @author Yuan Suarez
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
    private String id;

    /**
     *
     *
     * @param brand brand
     * @param model model
     * @param description description
     * @param price price
     */
    public Car(String brand, String model, String description, double price) {
        this.id = generateRandomId();
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
    public Car(String id, String brand, String model, String description, double price) {
        this.id = id;
        this.description = description.trim();
        this.brand = brand.trim();
        this.model = model.trim();
        this.price = price;
    }

    private String generateRandomId() {
        Random random = new Random();
        int randomNumber = random.nextInt(0x10000);
        return String.format("%04X", randomNumber);
    }

    /**
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *
     * @return
     */
    public double getPrice() {
        return this.price;
    }

    /**
     *
     * @return
     */
    public String getId() {
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
    public void setDescription(String description) {
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
}
