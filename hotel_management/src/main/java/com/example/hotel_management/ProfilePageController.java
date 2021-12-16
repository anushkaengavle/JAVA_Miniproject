package com.example.hotel_management;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;


public class ProfilePageController implements Initializable {
    @FXML
    public Label lb1;//name


    @FXML
    private Label lb2;//pass

    @FXML
    private Label lb3;//email

    @FXML
    private Label lb4;//id

    @FXML
    private Label lb5;//phone no

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{  DatabaseConnection connectnow = new DatabaseConnection();
            Connection connectdb = connectnow.getconnection();
            Statement state = connectdb.createStatement();

            String select = "select * from customer where cus_name ='"+loginpageController.name+"' and cus_pass='"+loginpageController.password+"'";
            try {

                ResultSet rs = state.executeQuery(select);

                while (rs.next()) {


                    lb1.setText(rs.getString("cus_name"));
                    lb2.setText(rs.getString(5));
                    lb3.setText(rs.getString(4));
                    lb4.setText(rs.getString(6));
                    lb5.setText(rs.getString(3));


                }
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(""));
                Scene scene = new Scene(fxmlLoader.load(), 900, 750);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            } catch (Exception ep) {
                ep.printStackTrace();
            } }catch (Exception ep) {
            ep.printStackTrace();}
    }

    @FXML
    public void Bbutton(ActionEvent event) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("homepage.fxml"));
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Scene scene = new Scene(fxmlLoader.load(), 900, 750);
            Stage stage = new Stage();
            stage.setTitle("homepage");
            stage.setScene(scene);
            stage.show();
        } catch (Exception ep) {
            ep.printStackTrace();
        }
    }

    @FXML
    public void DB(ActionEvent event) throws Exception {
        DatabaseConnection connectnow = new DatabaseConnection();
        Connection connectdb = connectnow.getconnection();
        Statement state = connectdb.createStatement();

        String delete = "delete from customer where cus_name='" + loginpageController.name + "' and cus_pass='" + loginpageController.password + "'";

        try {
            state.executeUpdate(delete);
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("loginpage.fxml"));
            ((Node) (event.getSource())).getScene().getWindow().hide();

            Scene scene = new Scene(fxmlLoader.load(), 456, 455);
            Stage stage = new Stage();
            stage.setTitle("login ");
            stage.setScene(scene);
            stage.show();
        } catch (Exception ep) {
            ep.printStackTrace();
        } finally {

            state.close();
        }
    }
    }