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
    public void onHelloButtonClick(ActionEvent event) throws Exception  {
        DatabaseConnection connectnow = new DatabaseConnection();
        Connection connectdb = connectnow.getconnection();
        String verifylogin = "select count(1) from customer where cus_name='" + T1.getText() + "' and cus_pass='" + T2.getText() + "'";
        String verifyuser = "select count(1) from user where user_name='" + T1.getText() + "' and user_password='" + T2.getText() + "'";

        try {
            Statement statement = connectdb.createStatement();
            ResultSet queryResult = statement.executeQuery(verifylogin);
            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    try {
                        NB.setText("Login Success");
                        Stage stage = new Stage();
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("homepage.fxml"));
                        ((Node)(event.getSource())).getScene().getWindow().hide();
                        Scene scene = new Scene(fxmlLoader.load(),900, 750);
                        stage.setTitle("Hello!");
                        stage.setScene(scene);
                        stage.show();
                    }
                    catch (Exception ep) {
                        ep.printStackTrace();
                    } finally {

                        statement.close();
                    }
                }}
                Statement state = connectdb.createStatement();
                ResultSet qResult = state.executeQuery(verifyuser);
                while (qResult.next()) {
                    if  (qResult.getInt(1) == 1) {
                            try {
                                NB.setText("Login Success");
                                Stage stage = new Stage();
                                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CheckIn.fxml"));
                                ((Node)(event.getSource())).getScene().getWindow().hide();
                                Scene scene = new Scene(fxmlLoader.load(),900, 750);
                                stage.setTitle("Hello!");
                                stage.setScene(scene);
                                stage.show();
                            }
                            catch (Exception ep) {
                                ep.printStackTrace();
                            }
                            finally {

                                state.close();
                            }
                    }

                else {
                    NB.setText("Invalid login");
                }
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
        Scene scene = new Scene(fxmlLoader.load(),600, 400);
        stage.setTitle("sign up");
        stage.setScene(scene);
        stage.show();
    }
}

