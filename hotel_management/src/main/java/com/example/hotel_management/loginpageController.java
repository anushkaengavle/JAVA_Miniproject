package com.example.hotel_management;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class loginpageController {

    @FXML
    private Label NB;
    @FXML
    private TextField T1;
    @FXML
    private TextField T2;
    @FXML


    public static String name, password;

    public void onHelloButtonClick(ActionEvent event) throws Exception  {
        DatabaseConnection connectnow = new DatabaseConnection();
        Connection connectdb = connectnow.getconnection();

        name = T1.getText();
        password = T2.getText();

        String verifylogin = "select count(1) from customer where cus_name='" + name + "' and cus_pass='" + password + "'";
        String verifyuser = "select count(1) from user where user_name='" + name + "' and user_password='" + password + "'";

        try {
            Statement statement = connectdb.createStatement();
            ResultSet queryResult = statement.executeQuery(verifylogin);

                    try {
                        while (queryResult.next()) {
                            if (queryResult.getInt(1) >= 1) {
                                NB.setText("Login Success");
                                Stage stage = new Stage();
                                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("homepage.fxml"));
                                ((Node) (event.getSource())).getScene().getWindow().hide();
                                Scene scene = new Scene(fxmlLoader.load(), 900, 750);
                                stage.setTitle("Hello!");
                                stage.setScene(scene);
                                stage.show();
                            }}}
                    catch (Exception ep) {
                        ep.printStackTrace();
                    } finally {

                        statement.close();
                    }
            Statement state = connectdb.createStatement();
            ResultSet qResult = state.executeQuery(verifyuser);

                            try {

                                while (qResult.next()) {
                                    if  (qResult.getInt(1) >= 1) {
                                NB.setText("Login Success");
                                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CheckIn.fxml"));
                                ((Node) (event.getSource())).getScene().getWindow().hide();
                                Scene scene = new Scene(fxmlLoader.load(), 999, 585);
                                Stage stage = new Stage();
                                stage.setTitle("Management");
                                stage.setScene(scene);
                                stage.show();
                            }
                                    else {
                                        NB.setText("Invalid login");
                                    }
                                }}
                            catch (Exception ep) {
                                ep.printStackTrace();
                            }
                            finally {

                                state.close();
                            }



        } catch (Exception ep) {
            ep.printStackTrace();
        }

    }
    @FXML
    public void  sp (ActionEvent event) throws Exception{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("signuppage.fxml"));
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Scene scene = new Scene(fxmlLoader.load(),600, 514);
        stage.setTitle("sign up");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void forgot (ActionEvent event) throws Exception {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("forgetpassword.fxml"));
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Scene scene = new Scene(fxmlLoader.load(),600, 514);
        stage.setTitle("Forgot password");
        stage.setScene(scene);
        stage.show();
    }
    }


