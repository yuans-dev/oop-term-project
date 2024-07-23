/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crms.lib;

import java.util.Random;

/**
 * CarFactory is a factory class designed to create {@code Car} objects
 * <p>
 * Its main purpose is to make sure that created {@code Car} objects always have
 * a unique ID.</p>
 *
 * @author Yuan Suarez
 */
public class CarFactory {

    private final CarInventory carInventory;

    /**
     * Constructs a {@code CarFactory} object.
     *
     * @param carInventory The {@code CarInventory} instance required for some
     * methods.
     */
    public CarFactory(CarInventory carInventory) {
        this.carInventory = carInventory;
    }

    /**
     * Creates a {@code Car} object with specified brand, model, description,
     * and price. This method makes sure that the {@code Car} object has a
     * unique ID;
     *
     * @param brand Brand of the car
     * @param model Model of the car
     * @param description Description of the car
     * @param price Price of the car
     * @return {@code Car} object with a unique ID
     */
    public Car createCar(String brand, String model, String description, double price) {
        String id;
        do {
            id = generateRandomId();
        } while (carInventory.getCarById(id) != null);//Regenerate if it returns a car object
        return new Car(id, brand, model, description, price);
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
