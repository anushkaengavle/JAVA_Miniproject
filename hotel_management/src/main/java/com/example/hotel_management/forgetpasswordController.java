package com.example.hotel_management;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class forgetpasswordController {

    @FXML
    private TextField TF1;//

    @FXML
    private TextField TF2; //

    @FXML

    private Label lb1;// in valid password
    @FXML
    public void back (ActionEvent event) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("loginpage.fxml"));
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Scene scene = new Scene(fxmlLoader.load(), 456, 455);
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Stage stage = new Stage();
        stage.setTitle("login");
        stage.setScene(scene);
        stage.show();
    }
    @FXML

    public void change (ActionEvent event) throws Exception {
        DatabaseConnection connectnow = new DatabaseConnection();
        Connection connectdb = connectnow.getconnection();
        Statement state = connectdb.createStatement();
        String email = TF1.getText();
        String password = TF2.getText();

        String change = "update customer set cus_pass='" + password + "'where cus_email='" + email + "'";

        try {
            state.executeUpdate(change);
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("loginpage.fxml"));
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Scene scene = new Scene(fxmlLoader.load(), 456, 455);
            Stage stage = new Stage();
            stage.setTitle("login");
            stage.setScene(scene);
            stage.show();
        } catch (Exception ep) {
            ep.printStackTrace();
        } finally {
            state.close();
        }

    }
}



