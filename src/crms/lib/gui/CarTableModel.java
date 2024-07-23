/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crms.lib.gui;

import crms.lib.CarReport;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u1ben
 */
public class CarTableModel extends AbstractTableModel implements IReportTableModel {

    private final ArrayList<CarReport> reports;
    private final String[] columnNames = {"ID", "Brand", "Model", "Description", "Availability", "Price (php/day)"};

    public CarTableModel(ArrayList<CarReport> reports) {
        this.reports = reports;
    }

    @Override
    public int getRowCount() {
        return reports.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CarReport report = reports.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return report.getCar().getId();
            case 1:
                return report.getCar().getBrand();
            case 2:
                return report.getCar().getModel();
            case 3:
                return report.getCar().getDescription();
            case 4:
                return report.isAvailable() ? "Available" : "Rented";
            case 5:
                return report.getCar().getPrice();
            default:
                throw new IllegalArgumentException("Invalid column index");
        }
    }

    public CarReport getReportAt(int rowIndex) {
        return reports.get(rowIndex);
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
