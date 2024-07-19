/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crms.lib.gui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;

/**
 *
 * @author u1ben
 */
public class RentDateVerifier extends InputVerifier {

    @Override
    public boolean verify(JComponent input) {
        JFormattedTextField tf = (JFormattedTextField) input;
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yy");
            LocalDate date = LocalDate.parse(tf.getText(), dateTimeFormatter);
            return date.equals(LocalDate.now()) || date.isAfter(LocalDate.now());
        } catch (Exception e) {

            return false;
        }

    }

}
