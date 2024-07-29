/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crms.lib.gui;

/**
 * @param <T> Report type
 * @author Yuan Suarez
 */
public interface IReportTableModel<T> {

    T getReportAt(int row);
}
