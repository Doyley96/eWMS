/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cqumail.doyle.brendan.ewms;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author brend
 */
public class ErrorHandler {
    //Checks if an input contains only numeric characters
    public boolean isNumeric(String param)
    {
	for (int i = 0; i < param.length(); i++)
    	{
    	    if (!Character.isDigit(param.charAt(i)))
		return false;
	}
	return true;
    }
    
    public void errorMessage(String error) { 
        Alert alert = new Alert(Alert.AlertType.ERROR, error);
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
               
            }
        });
        
    }
}
