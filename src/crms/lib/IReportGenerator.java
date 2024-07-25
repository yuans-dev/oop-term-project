/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crms.lib;

import java.util.ArrayList;

/**
 * Interface for generating reports.
 * <p>
 * This interface defines a method to generate a report in the form of an
 * {@code ArrayList} of objects of type {@code T}.
 * </p>
 *
 * @param <T> the type of objects in the report
 *
 * @version 1.0
 */
public interface IReportGenerator<T> {

    /**
     * Generates a report.
     *
     * @return an {@code ArrayList} of objects of type {@code T}
     */
    ArrayList<T> generateReport();
}
