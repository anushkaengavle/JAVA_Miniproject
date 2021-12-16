package com.example.hotel_management;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.Statement;


public class supportController {

    @FXML
    private Text Help;// default text
    @FXML
    private TextField T1; //text
    @FXML
    private Button NB1;
    @FXML

    public static String question;

    public void ok(ActionEvent event) throws Exception{
        DatabaseConnection connectnow = new DatabaseConnection();
        Connection connectdb = connectnow.getconnection();
        Statement state = connectdb.createStatement();
        question=T1.getText();
        try {
            String help = "insert into question values('"+loginpageController.name+"','"+question+"','');";
            state.executeUpdate(help);
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("homepage.fxml"));
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Scene scene = new Scene(fxmlLoader.load(), 900, 750);
            Stage stage = new Stage();
            stage.setTitle("homepage");
            stage.setScene(scene);
            stage.show();



        }catch (Exception ep) {
            ep.printStackTrace();
        }
        finally {
            state.close();
        }
    }
}
