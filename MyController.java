package com.smriti.javafx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class MyController implements Initializable {
    @FXML
    public Label welcome;
    @FXML
    public ChoiceBox<String> choicebox;
    @FXML
    public TextField input;
    @FXML
    public Button convert;

    private static  final String C_to_F ="Celsius to Fahrenheit";
    private static final String F_to_C = "Fahrenheit to Celsius";

    private boolean isC_to_F = true;





    @Override
    //act as a entry point for this controller
    public void initialize(URL location, ResourceBundle resources) {
        choicebox.getItems().add(C_to_F);
        choicebox.getItems().add(F_to_C);
        choicebox.setValue(C_to_F);
        choicebox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals(C_to_F)) {
                isC_to_F = true;

            } else {
                isC_to_F = false;
            }
        });


        convert.setOnAction((event) -> {
            convert();
        });


    }

    private void convert() {
        //extract input from the text field
        String inputuser =  input.getText();
        float enteredTemprature  = 0.0f;
        try{
              enteredTemprature  = Float.parseFloat(inputuser);
        }catch(Exception e ){
             warnUser();
             return;
             // after return no code is executed in JAVA

        }



        float newTemprature = 0.0f ;
        if(isC_to_F){
            newTemprature = (enteredTemprature*9/5)+32 ;

        }else {
            newTemprature = (enteredTemprature -32 )*5/9 ;

        }
        display(newTemprature);

    }

    private void warnUser() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("INVALID INPUT");
        alert.setContentText("please enter valid input temprature ");
        alert.show();
    }

    private void display(float newTemprature) {
        String unit =  isC_to_F ?" F":" C";
        System.out.println("the scaled temprature is :"+ newTemprature+unit);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("RESULT");
        alert.setContentText("the scaled temprature is :"+ newTemprature+unit);
        alert.show();
    }

}