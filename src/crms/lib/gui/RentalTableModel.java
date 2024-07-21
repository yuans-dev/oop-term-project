/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crms.lib.gui;

import crms.lib.RentalReport;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u1ben
 */
public class RentalTableModel extends AbstractTableModel {

    private final ArrayList<RentalReport> reports;
    private final String[] columnNames = {"ID", "Unit", "Rent From", "Rent Until", "Duration", "Status"};

    public RentalTableModel(ArrayList<RentalReport> reports) {
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
        RentalReport report = reports.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return report.getId();
            case 1:
                return report.getRental().getCar().getBrand() + " " + report.getRental().getCar().getModel();
            case 2:
                return report.getRental().getStartDate().format(DateTimeFormatter.ofPattern("M/dd/yy"));
            case 3:
                return report.getRental().getEndDate().format(DateTimeFormatter.ofPattern("M/dd/yy"));
            case 4:
                return report.getDuration();
            case 5:
                return report.getStatus();
            default:
                throw new IllegalArgumentException("Invalid column index");
        }
    }

    public RentalReport getReportAt(int rowIndex) {
        return reports.get(rowIndex);
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
