/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cqumail.doyle.brendan.ewms;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class FXMLMenuController {
    
    ErrorHandler EH = new ErrorHandler();

    @FXML
    private TextField txtField;
    
    void clearTxt() {
        txtField.clear();
    }

    @FXML
    void btnEditBooking(ActionEvent event) throws IOException, SQLException {
        if (!EH.isNumeric(txtField.getText())) {
            EH.errorMessage("Please enter a valid ID number, numerals only.");
            txtField.clear();
            return;
        }
        if (txtField.getText().equals("")) {
            EH.errorMessage("Text field cannot be blank.");
            return;
        }
        
        // Connect to a database
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/ewastemanagement", "root", "bnde1296");// Your own "password"

        // Create a statement
        Statement statement = connection.createStatement();

        // check if customerID exist in database
        String q = String.format("SELECT * FROM ewastemanagement.booking WHERE bookingID = '%s';", txtField.getText());
        ResultSet rs = statement.executeQuery(q);
        if (!rs.isBeforeFirst()) {
            EH.errorMessage("Customer does not exist.");
            txtField.clear();
            return;
        }
        ResultSet rs2 = statement.executeQuery(q);
        App.currentCustomerID = rs2.getInt("customerID");
        connection.close();
        
        App.currentBookingID = Integer.parseInt(txtField.getText());
        App.setRoot("FXMLBooking");
    }

    @FXML
    void btnEditCustomer(ActionEvent event) throws IOException, SQLException {
        if (!EH.isNumeric(txtField.getText())) {
            EH.errorMessage("Please enter a valid ID number, numerals only.");
            txtField.clear();
            return;
        }
        if (txtField.getText().equals("")) {
            EH.errorMessage("Text field cannot be blank.");
            return;
        }
        
        // Connect to a database
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/ewastemanagement", "root", "bnde1296");// Your own "password"

        // Create a statement
        Statement statement = connection.createStatement();

        // check if customerID exist in database
        String q = String.format("SELECT * FROM ewastemanagement.customer WHERE customerID = '%s';", txtField.getText());
        ResultSet rs = statement.executeQuery(q);
        if (!rs.isBeforeFirst()) {
            EH.errorMessage("Customer does not exist.");
            txtField.clear();
            return;
        }
        connection.close();
        App.currentCustomerID = Integer.parseInt(txtField.getText());
        App.setRoot("FXMLCustomer");
    }

    @FXML
    void btnExit(ActionEvent event) {
        App.exit();
    }

    @FXML
    void btnNewBooking(ActionEvent event) throws IOException, SQLException {
        if (!EH.isNumeric(txtField.getText())) {
            EH.errorMessage("Please enter a valid ID number, numerals only.");
            txtField.clear();
            return;
        }
        if (txtField.getText().equals("")) {
            EH.errorMessage("Text field cannot be blank.");
            return;
        }
        
        // Connect to a database
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/ewastemanagement", "root", "bnde1296");// Your own "password"

        // Create a statement
        Statement statement = connection.createStatement();

        // check if customerID exist in database
        String q = String.format("SELECT * FROM ewastemanagement.customer WHERE customerID = '%s';", txtField.getText());
        ResultSet rs = statement.executeQuery(q);
        if (!rs.isBeforeFirst()) {
            EH.errorMessage("Customer does not exist.");
            txtField.clear();
            connection.close();
            return;
        }

        // Execute a query
        ResultSet resultSet = statement.executeQuery("SELECT MAX(bookingID) FROM booking;");
        while (resultSet.next()) {
            App.currentBookingID = resultSet.getInt(1) + 1;
        }
        App.currentCustomerID = Integer.parseInt(txtField.getText());
        App.setRoot("FXMLBooking");
    }

    @FXML
    void btnNewCustomer(ActionEvent event) throws IOException, SQLException {
        // Connect to a database
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/ewastemanagement", "root", "bnde1296");// Your own "password"

        // Create a statement
        Statement statement = connection.createStatement();

        // Execute a query
        ResultSet resultSet = statement.executeQuery("SELECT MAX(customerID) FROM Customer;");
        while (resultSet.next()) {
            App.currentCustomerID = resultSet.getInt(1) + 1;
        }
        App.setRoot("FXMLCustomer");
    }

    @FXML
    void btnSearch(ActionEvent event) throws IOException {
                App.setRoot("FXMLDisplay");       
    }
        
    boolean bookingExist(String s) throws SQLException {
        if (!EH.isNumeric(txtField.getText())) {
            EH.errorMessage("Please enter a valid ID number, numerals only.");
            txtField.clear();
            return false;
        }
        boolean exist = true;
        // Connect to a database
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/ewastemanagement", "root", "bnde1296");// Your own "password"

        // Create a statement
        Statement statement = connection.createStatement();

        // check if customerID exist in database
        String q = String.format("SELECT * FROM ewastemanagement.booking WHERE bookingID = '%s';", txtField.getText());
        ResultSet rs = statement.executeQuery(q);
        if (!rs.isBeforeFirst()) {
            EH.errorMessage("Booking does not exist.");
            exist = false;
            return exist;
        }
        App.currentBookingID = Integer.parseInt(txtField.getText());
        connection.close();
        
        return false;
    }
}
