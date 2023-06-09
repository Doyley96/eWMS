/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cqumail.doyle.brendan.ewms;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class FXMLMenuController {

    @FXML
    private TextField txtField;
    
    void clearTxt() {
        txtField.clear();
    }

    @FXML
    void btnEditBooking(ActionEvent event) throws IOException {
        App.setRoot("FXMLBooking");
    }

    @FXML
    void btnEditCustomer(ActionEvent event) throws IOException {
        App.setRoot("FXMLCustomer");
    }

    @FXML
    void btnExit(ActionEvent event) {
        App.exit();
    }

    @FXML
    void btnNewBooking(ActionEvent event) throws IOException {
        App.setRoot("FXMLBooking");
    }

    @FXML
    void btnNewCustomer(ActionEvent event) throws IOException {
        App.setRoot("FXMLCustomer");
    }

    @FXML
    void btnSearchBooking(ActionEvent event) {

    }

    @FXML
    void btnSearchCustomer(ActionEvent event) {

    }

}
