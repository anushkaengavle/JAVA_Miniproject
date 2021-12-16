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

public class signuppageController {

    @FXML
    private Button NB2; //next

    @FXML
    private Label LB1; // error message

    @FXML
    private TextField TF1; //name

    @FXML
    private TextField TF2; //moblie

    @FXML
    private TextField TF3; //email

    @FXML
    private TextField TF4; //pass

    @FXML
    private TextField TF5; //id
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

    public static String name,mobile,email,pass,id;
    public int phone;
    public void ntbutton2(ActionEvent event) throws Exception {
        DatabaseConnection connectnow = new DatabaseConnection();
        Connection connectdb = connectnow.getconnection();
        Statement state = connectdb.createStatement();

        name = TF1.getText();
        mobile = TF2.getText();
        phone=Integer.parseInt(mobile);
        email = TF3.getText();
        pass = TF4.getText();
        id = TF5.getText();

        if (name.equals("")|| mobile.equals("") || email.equals("") || pass.equals("") || id.equals("")) {
            LB1.setText("****All Fields Are Required****");
        }
        else {
            String custdetail = "insert into customer (cus_id,cus_name,cus_mobile,cus_email,cus_pass,c_IDproof) select max(cus_id)+1,'"+name+"','"+phone+"','"+email+"','"+pass+"','"+id+"' from customer";
            state.executeUpdate(custdetail);

            try {
                LB1.setText("Login succuessful");
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("loginpage.fxml"));
                ((Node) (event.getSource())).getScene().getWindow().hide();
                Scene scene = new Scene(fxmlLoader.load(), 456, 455);
                Stage stage = new Stage();
                stage.setTitle("login");
                stage.setScene(scene);
                stage.show();
            } catch (Exception ep) {
                ep.printStackTrace();
            }
            finally {
                state.close();
            }
        }
    }
}