/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crms.lib;

import java.util.ArrayList;

/**
 *
 * @author u1ben
 */
public abstract class Database<T> {

    protected String filename;
    protected ArrayList<T> dataList;

    public abstract void saveToDisk();

    public abstract void fetchFromDisk();

    public abstract T getItemById(String id);

}
