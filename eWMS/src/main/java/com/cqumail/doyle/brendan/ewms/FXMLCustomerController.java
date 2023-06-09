/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cqumail.doyle.brendan.ewms;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLCustomerController {

    @FXML
    private Label lblCustomerID;

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

    @FXML
    void btnExit(ActionEvent event) throws IOException {
        App.setRoot("FXMLMenu");
    }

    @FXML
    void btnSave(ActionEvent event) throws IOException {
        App.setRoot("FXMLMenu");
    }

}
