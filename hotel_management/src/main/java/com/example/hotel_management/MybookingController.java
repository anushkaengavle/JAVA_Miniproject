package com.example.hotel_management;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class MybookingController implements Initializable {

    @FXML
    private Rectangle head;

    @FXML
    private Text destiny;

    @FXML
    private Rectangle foot;

    @FXML
    private Text hp;

    @FXML
    private Text tac;

    @FXML
    private Text pn;

    @FXML
    private Text ct;

    @FXML
    private Button bb;

    @FXML
    private AnchorPane display;

    @FXML
    private Label lb1;//check in

    @FXML
    private Label lb2;//check out

    @FXML
    private Label lb3;//price

    @FXML
    private Label lb7;//child
    @FXML
    private Label lb8;//dest
    @FXML
    private Label lb6;//adult

    @FXML
    private Label lb5;//roomtype

    @FXML
    private Label lb4;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      try{  DatabaseConnection connectnow = new DatabaseConnection();
        Connection connectdb = connectnow.getconnection();
        Statement state = connectdb.createStatement();

        String select = "select * from booking where name ='" + loginpageController.name + "'";
        try {

            ResultSet resultSet = state.executeQuery(select);

            while (resultSet.next()) {

                lb8.setText(resultSet.getString(2));
                lb1.setText(resultSet.getString(7));
                lb2.setText(resultSet.getString(8));
                lb4.setText(resultSet.getString(9));
                lb6.setText(resultSet.getString(10));
                lb7.setText(resultSet.getString(11));
                lb5.setText(resultSet.getString(12));
                lb3.setText(resultSet.getString(13));

            }
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(""));
            Scene scene = new Scene(fxmlLoader.load(), 900, 750);
            Stage stage = new Stage();
            stage.setTitle("homepage");
            stage.setScene(scene);
            stage.show();
        } catch (Exception ep) {
            ep.printStackTrace();
        } finally {

            state.close();
        }}catch (Exception ep) {
              ep.printStackTrace();}
    }

    @FXML
    public void logout(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("loginpage.fxml"));
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Scene scene = new Scene(fxmlLoader.load(), 455, 456);
        Stage stage = new Stage();
        stage.setTitle("login");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void back (ActionEvent event) throws Exception{
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("homepage.fxml"));
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Scene scene = new Scene(fxmlLoader.load(), 900, 750);
            Stage stage = new Stage();
            stage.setTitle("homepage");
            stage.setScene(scene);
            stage.show();
        }catch (Exception ep) {
            ep.printStackTrace();
        }}

    }







