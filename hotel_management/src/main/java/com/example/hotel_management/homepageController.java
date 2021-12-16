package com.example.hotel_management;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class homepageController {
    @FXML
    private AnchorPane AP;

    @FXML
    private Rectangle head;

    @FXML
    private Text destiny;

    @FXML
    private ImageView main_img;

    @FXML
    private Text moto;

    @FXML
    private Text dt;

    @FXML
    private TextField dtb;

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
    private Button c1;

    @FXML
    private Button sb;

    @FXML
    private Button c4;

    @FXML
    private Button c2;

    @FXML
    private Button LB1;
    public static String dest,price;
    public static String username;

        @FXML
        public void logoutbutton (ActionEvent event) throws Exception{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("loginpage.fxml"));

            ((Node) (event.getSource())).getScene().getWindow().hide();
            Scene scene = new Scene(fxmlLoader.load(), 455, 456);
            Stage stage = new Stage();
            stage.setTitle("login");
            stage.setScene(scene);
            stage.show();
        }
        @FXML
        public void Searchbutton (ActionEvent event) throws Exception {
            DatabaseConnection connectnow = new DatabaseConnection();
            Connection connectdb = connectnow.getconnection();
            Statement state = connectdb.createStatement();

            dest = dtb.getText();
            String search = "select * from hotel where h_city ='" + dest + "'";
            try {
                state.executeQuery(search);
                ResultSet resultSet = state.executeQuery(search);
                System.out.print(resultSet.toString());
                while (resultSet.next()) {
                    price = resultSet.getString(5);
                }
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Booking.fxml"));
                ((Node) (event.getSource())).getScene().getWindow().hide();
                Scene scene = new Scene(fxmlLoader.load(), 999, 585);
                Stage stage = new Stage();
                stage.setTitle("booking");
                stage.setScene(scene);
                stage.show();
            } catch (Exception ep) {
                ep.printStackTrace();
            } finally {

                state.close();
            }
        }
        @FXML
        public void profile (ActionEvent event) throws Exception{
                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ProfilePage.fxml"));
                ((Node) (event.getSource())).getScene().getWindow().hide();
                Scene scene = new Scene(fxmlLoader.load(), 900, 750);
                stage.setTitle("profile");
                stage.setScene(scene);
                stage.show();
            }



        @FXML
        public void Feedback (ActionEvent event) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Feedbackmainpage.fxml"));
            ((Node) (event.getSource())).getScene().getWindow().hide();
        Scene scene = new Scene(fxmlLoader.load(), 456, 371);
        Stage stage = new Stage();
        stage.setTitle("Feedback");
        stage.setScene(scene);
        stage.show();
    }
        @FXML
        public void Support (ActionEvent event) throws Exception{
            try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("support.fxml"));
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Scene scene = new Scene(fxmlLoader.load(), 500, 206);
            Stage stage = new Stage();
            stage.setTitle("Support");
            stage.setScene(scene);
            stage.show();
        }
            catch (Exception ep) {
                ep.printStackTrace();
            }
        }
        @FXML
        public void offer (ActionEvent event) throws Exception{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("offer.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Special offer");
            stage.setScene(scene);
            stage.show();
        }
        @FXML

    public void book(ActionEvent event) throws Exception{
            try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MyBooking.fxml"));
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Scene scene = new Scene(fxmlLoader.load(), 900, 750);
            Stage stage = new Stage();
            stage.setTitle("booking");
            stage.setScene(scene);
            stage.show();
        }catch (Exception ep) {
                ep.printStackTrace();
        }
    }


}



