/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cqumail.doyle.brendan.ewms;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLBookingController {

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

    @FXML
    void btnCancel(ActionEvent event) throws IOException {
        App.setRoot("FXMLMenu");
    }

    @FXML
    void btnExit(ActionEvent event) throws IOException {
        App.setRoot("FXMLMenu");
    }

    @FXML
    void btnSave(ActionEvent event) throws IOException {
        App.setRoot("FXMLWaste");
    }

}
