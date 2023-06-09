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

public class FXMLWasteController {

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

    @FXML
    void btnExit(ActionEvent event) throws IOException {
        App.setRoot("FXMLMenu");
    }

    @FXML
    void btnSave(ActionEvent event) throws IOException {
        App.setRoot("FXMLMenu");

    }

}

