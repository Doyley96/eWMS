/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cqumail.doyle.brendan.ewms;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLBookingController implements Initializable {
    
    ErrorHandler EH = new ErrorHandler();

    @FXML
    private Label lblBookingID;

    @FXML
    private Label lblCustomerID;

    @FXML
    private TextArea txtArea;

    @FXML
    private TextField txtBookingDate;

    @FXML
    private TextField txtRemovalDate;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblCustomerID.setText(String.valueOf(App.currentCustomerID));
        lblBookingID.setText(String.valueOf(App.currentBookingID));
    }

    @FXML
    void btnCancel(ActionEvent event) throws IOException {
        App.setRoot("FXMLMenu");
    }

    @FXML
    void btnExit(ActionEvent event) throws IOException {
        App.setRoot("FXMLMenu");
    }

    @FXML
    void btnSave(ActionEvent event) throws IOException, SQLException {
        if (!checkFields()) return;
        
        // Connect to a database
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/ewastemanagement", "root", "bnde1296");// Your own "password"

        // Create a statement
        Statement statement = connection.createStatement();
        
        // Execute a query to add new row to db
        String q = String.format("INSERT INTO `ewastemanagement`.`booking` (`customerID`, `wasteID`, `status`, `bookingDate`, `removalDate`) VALUES ('%d', '%d', '%s', '%s', '%s');", App.currentCustomerID, App.currentBookingID, "Completed", txtBookingDate.getText(), txtRemovalDate.getText());
        Integer save = statement.executeUpdate(q);
        connection.close();
        txtBookingDate.clear();
        txtRemovalDate.clear();
        
        App.setRoot("FXMLWaste");
    }
    
    boolean checkFields() {
        boolean error = true;
        
        if (txtBookingDate.getText().equals("")) {
            EH.errorMessage("Booking Date cannot be left blank.");
            error = false;
        }
        
        if (txtRemovalDate.getText().equals("")) {
            EH.errorMessage("Removal Date cannot be left blank.");
            error = false;
        }
        
        return error;
    }

}
