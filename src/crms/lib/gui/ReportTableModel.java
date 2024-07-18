/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crms.lib.gui;

import crms.lib.ReportViewModel;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u1ben
 */
public class ReportTableModel extends AbstractTableModel{
    private final ArrayList<ReportViewModel> reports;
    private final String[] columnNames = {"Brand", "Model", "Description","Availability"};

    public ReportTableModel(ArrayList<ReportViewModel> reports) {
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
        ReportViewModel report = reports.get(rowIndex);
        switch (columnIndex) {
            case 0: return report.getCar().getBrand();
            case 1: return report.getCar().getModel();
            case 2: return report.getCar().getDescription();
            case 3: return report.isAvailable() ? "Available" : "Rented";
            default: throw new IllegalArgumentException("Invalid column index");
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}

