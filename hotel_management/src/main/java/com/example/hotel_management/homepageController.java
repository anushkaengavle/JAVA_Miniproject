package com.example.hotel_management;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;

public class homepageController {
    @FXML
    private AnchorPane AP;

    @FXML
    private Rectangle head;

    @FXML
    private Text destiny;

    @FXML
    private Rectangle db;

    @FXML
    private MenuButton menu;

    @FXML
    private Line dl1;

    @FXML
    private Line dl2;

    @FXML
    private ImageView main_img;

    @FXML
    private Text moto;

    @FXML
    private Text dt;

    @FXML
    private TextField dtb;

    @FXML
    private Text ci;

    @FXML
    private TextField cib;

    @FXML
    private Text co;

    @FXML
    private TextField cob;

    @FXML
    private Button sb;

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
    private Circle c1;

    @FXML
    private TextField t1;

    @FXML
    private Circle c2;

    @FXML
    private Circle c3;

    @FXML
    private Circle c4;

    @FXML
    private Circle c5;

    @FXML
    private Circle c6;

    @FXML
    private Circle c7;

    @FXML
    private TextField t2;

    @FXML
    private TextField t3;

    @FXML
    private TextField t4;

    @FXML
    private TextField t5;

    @FXML
    private TextField t6;

    @FXML
    private TextField t7;
        public void Menubutton(ActionEvent event) throws Exception {
            Stage stage = new Stage();
            stage.setTitle("ImageView Experiment 1");
            MenuButton menu = new MenuButton();
            Scene scene = new Scene(menu, 200, 100);
            stage.setScene(scene);
            stage.show();
        }
        @FXML
        public void logoutbutton (ActionEvent event) throws Exception{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("loginpage.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 455, 456);
            Stage stage = new Stage();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }
        @FXML
        public void Searchbutton (ActionEvent event) throws Exception{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Mybooking.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 900, 750);
            Stage stage = new Stage();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }
        @FXML
        public void profile (ActionEvent event) throws Exception{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ProfilePage.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 900, 750);
            Stage stage = new Stage();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }
        @FXML
        public void Feedback (ActionEvent event) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Feedbackmainpage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 424, 315);
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
        @FXML
        public void Support (ActionEvent event) throws Exception{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("support.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 500, 206);
            Stage stage = new Stage();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }
        @FXML
        public void offer (ActionEvent event) throws Exception{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("offer.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }
        }



