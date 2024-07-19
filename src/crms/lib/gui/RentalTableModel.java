/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crms.lib.gui;

import crms.lib.Rental;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u1ben
 */
public class RentalTableModel extends AbstractTableModel {

    private final ArrayList<Rental> rentals;
    private final String[] columnNames = {"Unit", "Rent From", "Rent Until", "Status"};

    public RentalTableModel(ArrayList<Rental> rentals) {
        this.rentals = rentals;
    }

    @Override
    public int getRowCount() {
        return rentals.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Rental rental = rentals.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rental.getCar().getId() + " " + rental.getCar().getBrand() + " " + rental.getCar().getModel();
            case 1:
                return rental.getStartDate().format(DateTimeFormatter.ofPattern("M/dd/yy"));
            case 2:
                return rental.getEndDate().format(DateTimeFormatter.ofPattern("M/dd/yy"));
            case 3:
                return LocalDate.now().isBefore(rental.getEndDate()) || LocalDate.now().equals(rental.getEndDate()) ? "Ongoing" : "Ended";
            default:
                throw new IllegalArgumentException("Invalid column index");
        }
    }

    public Rental getReportAt(int rowIndex) {
        return rentals.get(rowIndex);
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
