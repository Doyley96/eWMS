/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cqumail.doyle.brendan.ewms;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLCustomerController implements Initializable {
    
    ErrorHandler EH = new ErrorHandler();

    @FXML
    private Label lblCustomerID;
    
    @FXML
    private Label lblTips;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtMobile;

    @FXML
    private TextField txtStrName;

    @FXML
    private TextField txtStrNum;

    @FXML
    private TextField txtSuburb;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblCustomerID.setText(String.valueOf(App.currentCustomerID));
        try {
            loadCustomer();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void btnExit(ActionEvent event) throws IOException {
        clearFields();
        App.setRoot("FXMLMenu");
    }

    @FXML
    void btnSave(ActionEvent event) throws IOException, SQLException {
        if (!checkFields()) return;
        
        // Connect to a database
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/ewastemanagement", "root", "bnde1296");// Your own "password"

        // Create a statement
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT MAX(customerID) FROM Customer;");
        while (resultSet.next()) {
            if (Integer.parseInt(lblCustomerID.getText()) > resultSet.getInt(1)) {
                // Execute a query to add new row to db
                String q = String.format("INSERT INTO `ewastemanagement`.`customer` (`fName`, `lName`, `mobile`, `email`, `strNo`, `strName`, `suburb`) VALUES ('%s', '%s', '%d', '%s', '%d', '%s', '%s');", txtFirstName.getText(), txtLastName.getText(), Integer.parseInt(txtMobile.getText()), txtEmail.getText(), Integer.parseInt(txtStrNum.getText()), txtStrName.getText(), txtSuburb.getText());
                Integer save = statement.executeUpdate(q);
                connection.close();
                clearFields();
                App.setRoot("FXMLMenu");
                return;
            }
        }
        
        // Execute a query to add new row to db
        String q = String.format("UPDATE `ewastemanagement`.`customer` SET `fName` = '%s', `lName` = '%s', `mobile` = '%s', `email` = '%s', `strNo` = '%s', `strName` = '%s', `suburb` = '%s' WHERE (`customerID` = '%s');", txtFirstName.getText(), txtLastName.getText(), Integer.parseInt(txtMobile.getText()), txtEmail.getText(), Integer.parseInt(txtStrNum.getText()), txtStrName.getText(), txtSuburb.getText(), lblCustomerID.getText());
        Integer save = statement.executeUpdate(q);
        connection.close();
        clearFields();
        App.setRoot("FXMLMenu");
    }
    
    //Method for checking all fields contain valid input
    boolean checkFields() {
        boolean error = true;
        
        if (!EH.isNumeric(txtMobile.getText())) {
            EH.errorMessage("Phone Number must contain numbers only.");
            error = false;
        }
        
        if (!EH.isNumeric(txtStrNum.getText())) {
            EH.errorMessage("Street Number must contain numbers only.");
            error = false;
        }
        
        if (txtFirstName.getText().equals("")) {
            EH.errorMessage("First Name cannot be left blank.");
            error = false;
        }
        
        if (txtLastName.getText().equals("")) {
            EH.errorMessage("Last Name cannot be left blank.");
            error = false;
        }
        
        if (txtMobile.getText().equals("")) {
            EH.errorMessage("Phone number cannot be left blank.");
            error = false;
        }
        
        if (txtEmail.getText().equals("")) {
            EH.errorMessage("Email cannot be left blank.");
            error = false;
        }
        
        if (txtStrName.getText().equals("")) {
            EH.errorMessage("Street Name cannot be left blank.");
            error = false;
        }
        
        if (txtSuburb.getText().equals("")) {
            EH.errorMessage("Suburb cannot be left blank.");
            error = false;
        }
        
        return error;
    }
    
    //method for clearing fields
    void clearFields() {
        txtFirstName.clear();
        txtLastName.clear();
        txtMobile.clear();
        txtEmail.clear();
        txtStrNum.clear();
        txtStrName.clear();
        txtSuburb.clear();
        lblCustomerID.setText("xxxx");
    }
    
    void loadCustomer() throws SQLException {
        // Connect to a database
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/ewastemanagement", "root", "bnde1296");// Your own "password"

        // Create a statement
        Statement statement = connection.createStatement();

        // check if customerID exist in database
        String q = String.format("SELECT * FROM ewastemanagement.customer WHERE customerID = '%s';", lblCustomerID.getText());
        ResultSet rs = statement.executeQuery(q);
        
        while (rs.next()) {
            lblCustomerID.setText(rs.getString(1));
            txtFirstName.setText(rs.getString(2));
            txtLastName.setText(rs.getString(3));
            txtMobile.setText(rs.getString(4));
            txtEmail.setText(rs.getString(5));
            txtStrNum.setText(rs.getString(6));
            txtStrName.setText(rs.getString(7));
            txtSuburb.setText(rs.getString(8));
            lblTips.setText(rs.getString(9));
        }
        connection.close();
    }

}
