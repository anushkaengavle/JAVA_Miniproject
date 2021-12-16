package com.example.hotel_management;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookingController  {
    @FXML
    private Pane hotelname;

    @FXML
    private TextField T1;//id proof

    @FXML
    private TextField T3;//rooms

    @FXML
    private TextField T4;//adults

    @FXML
    private TextField T5;//child
    @FXML
    private TextField T6;//type
    @FXML
    private Label lb1;//destination
    @FXML
    
    private Label lb2;//price
    @FXML
    
    private Label lb3;//error
    @FXML
    private DatePicker d1;//check in

    @FXML
    private DatePicker d2;//check out

    public static String email,phone,idproof,adult,in,out,child,destination,room,price,dest,roomtype ;
           public static int total;

    String date(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
        return date.format(formatter);
    }
    @FXML
    public void logout (ActionEvent event) throws Exception{
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
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("homepage.fxml"));
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Scene scene = new Scene(fxmlLoader.load(), 900, 750);
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Stage stage = new Stage();
        stage.setTitle("homepage");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void getprice (ActionEvent event) throws Exception {

        dest= homepageController.dest;
        room= T3.getText();
        price= homepageController.price;

        int p=Integer.parseInt(price);
        int r=Integer.parseInt(room);
        total = p*r;
        String T=""+total;
        lb1.setText(dest);
        lb2.setText(T);
    }

    @FXML
    public void book (ActionEvent event) throws Exception{
        DatabaseConnection connectnow = new DatabaseConnection();
        Connection connectdb = connectnow.getconnection();
        Statement state = connectdb.createStatement();
        idproof = T1.getText();
        adult= T4.getText();
        in=d1.toString();
        out=d2.toString();
        child=T5.getText();
        roomtype =T6.getText();
        destination= homepageController.dest;
        price= homepageController.price;
        if(idproof.equals("")|| in.equals("") || out.equals("") || adult.equals("") || room.equals(""))
        {
            lb3.setText("*All Field are Required");
        }
        else{
        if (homepageController.dest!=dest){
            lb3.setText("Get final price to book");
            }
        String select="select * from customer where cus_name='"+loginpageController.name+"' and cus_pass='"+loginpageController.password+"'";
            try {
                ResultSet rs = state.executeQuery(select);
                while (rs.next()) {
                    phone =rs.getString(3);
                    email =rs.getString(4);


                }
            }
            catch (Exception ep) {
                ep.printStackTrace();
            }
                int mobile =Integer.parseInt(phone);
            String book="insert into booking (id,dest,name,email,phone,idproof,check_in,checkout,rooms,adults,children,room_type,totalprice) select max(id)+1,'"+destination+"','"+loginpageController.name+"','"+email+"','"+mobile+"','"+idproof+"','"+d1.getValue()+"','"+d2.getValue()+"','"+room+"','"+adult+"','"+child+"','"+roomtype+"','"+total+"' from booking";

            try{

                state.executeUpdate(book);


                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MyBooking.fxml"));
                ((Node) (event.getSource())).getScene().getWindow().hide();
                Scene scene = new Scene(fxmlLoader.load(), 900, 750);
                Stage stage = new Stage();
                stage.setTitle("booking");
                stage.setScene(scene);
                stage.show();
            }
            catch (Exception ep) {
                ep.printStackTrace();
            }finally {

                state.close();
            }
        }
    }


    }

