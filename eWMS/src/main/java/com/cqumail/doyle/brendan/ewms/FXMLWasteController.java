/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cqumail.doyle.brendan.ewms;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLWasteController implements Initializable {
    
    ErrorHandler EH = new ErrorHandler();

    @FXML
    private Label lblBookingID;

    @FXML
    private Label lblCustomerID;

    @FXML
    private TextField txtE1;

    @FXML
    private TextField txtGe1;

    @FXML
    private TextField txtGe2;

    @FXML
    private TextField txtGe3;

    @FXML
    private TextField txtGe4;

    @FXML
    private TextField txtGe5;

    @FXML
    private TextField txtGe6;

    @FXML
    private TextField txtGr1;

    @FXML
    private TextField txtGr2;

    @FXML
    private TextField txtM1;

    @FXML
    private TextField txtM2;

    @FXML
    private TextField txtM3;

    @FXML
    private TextField txtM4;

    @FXML
    private TextField txtM5;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblCustomerID.setText(String.format("%d", App.currentCustomerID));
        lblBookingID.setText(String.format("%d", App.currentBookingID));
    }

    @FXML
    void btnExit(ActionEvent event) throws IOException {
        App.setRoot("FXMLMenu");
    }

    @FXML
    void btnSave(ActionEvent event) throws IOException {
        App.setRoot("FXMLMenu");

    }

}

