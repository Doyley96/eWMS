/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cqumail.doyle.brendan.ewms;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLDisplayController {

    @FXML
    private TextField txtBooking;

    @FXML
    private TextArea display;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtStreet;

    @FXML
    private TextField txtSuburb;

    @FXML
    private TextField txtWaste;

    @FXML
    void btnBooking(ActionEvent event) {

    }

    @FXML
    void btnExit(ActionEvent event) throws IOException {
        clearFields();
        App.setRoot("FXMLMenu");
    }

    @FXML
    void btnFirstName(ActionEvent event) {

    }

    @FXML
    void btnLastName(ActionEvent event) {

    }

    @FXML
    void btnStreet(ActionEvent event) {

    }

    @FXML
    void btnSuburb(ActionEvent event) {

    }

    @FXML
    void btnWaste(ActionEvent event) {

    }
    
    void clearFields() {
        display.clear();
        txtStreet.clear();
        txtSuburb.clear();
        txtFirstName.clear();
        txtLastName.clear();
        txtBooking.clear();
        txtWaste.clear();
    }

}
