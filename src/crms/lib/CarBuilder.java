/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crms.lib;

import java.util.Random;

/**
 * CarBuilder is a factory class designed to create {@code Car} objects
 * <p>
 * Its main purpose is to make sure that created {@code Car} objects always have
 * a unique ID.</p>
 *
 * @author Yuan Suarez
 */
public class CarBuilder {

    private Car result;

    /**
     * Constructs a {@code CarFactory} object.
     */
    public CarBuilder() {
        result = new Car();
    }

    public CarBuilder setId(Database<Car> carDatabase) {
        String id;
        do {
            id = generateRandomId();
        } while (carDatabase.getItemById(id) != null);//Regenerate if it returns a car object
        result.setId(id);
        return this;
    }

    public CarBuilder setId(String id) {
        result.setId(id);
        return this;
    }

    public CarBuilder setBrand(String brand) {
        result.setBrand(brand);
        return this;
    }

    public CarBuilder setModel(String model) {
        result.setModel(model);
        return this;
    }

    public CarBuilder setDescription(String description) {
        result.setDescription(description);
        return this;
    }

    public CarBuilder setPrice(double price) {
        result.setPrice(price);
        return this;
    }

    public Car getResult() {
        return result;
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
}
