package com.example.hotel_management;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginpageController {

    @FXML
    private Label NB;
    @FXML
    private TextField T1;
    @FXML
    private TextField T2;
    @FXML
    public void onHelloButtonClick(ActionEvent event) throws Exception  {
        if (T1.getText().equals("ID") && T2.getText().equals("password")) {
            NB.setText("Login Success");
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("homepage.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),900, 750);
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }else { NB.setText("Invalid login");}}
    @FXML
    public void  sp (ActionEvent event) throws Exception{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("signuppage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),600, 400);
        stage.setTitle("sign up");
        stage.setScene(scene);
        stage.show();
    }
}

