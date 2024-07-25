/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crms.lib;

import java.util.ArrayList;

/**
 * The {@code Database} class is an abstract class that defines a generic
 * database structure and operations for managing a collection of objects of
 * type {@code T}.
 *
 * @param <T> The type of objects that this database will store.
 * @author Yuan Suarez
 */
public abstract class Database<T> {

    /**
     * The filename where the data is stored.
     */
    protected String filename;

    /**
     * The list that holds the objects of type {@code T}.
     */
    protected ArrayList<T> dataList;

    /**
     * Saves the data to the disk.
     */
    public abstract void saveToDisk();

    /**
     * Fetches the data from the disk.
     */
    public abstract void fetchFromDisk();

    /**
     * Retrieves an object by its ID.
     *
     * @param id The ID of the object to retrieve.
     * @return The object with the specified ID, or {@code null} if not found.
     */
    public abstract T getItemById(String id);

}
