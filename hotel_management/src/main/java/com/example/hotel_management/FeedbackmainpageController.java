package com.example.hotel_management;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class FeedbackmainpageController{

    @FXML
    private Slider TF1;
    @FXML
    private Slider TF2;
    @FXML
    private Slider TF3;
    @FXML
    private Slider TF4;
    @FXML

    public void submit(ActionEvent event) throws Exception {
        DatabaseConnection connectnow = new DatabaseConnection();
        Connection connectdb = connectnow.getconnection();
//        String feedback = "insert into feedback values('"+loginpageController.name+"','"+TF1.getValue()+"','"+TF2.getValue()+"','"+TF3.getValue()+"','"+TF4.getValue()+"')";
//        Statement state = connectdb.createStatement();
//        state.executeUpdate(feedback);

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("homepage.fxml"));
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Scene scene = new Scene(fxmlLoader.load(), 900, 750);
            Stage stage = new Stage();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        } catch (Exception ep) {
            ep.printStackTrace();
        }

    }

}

