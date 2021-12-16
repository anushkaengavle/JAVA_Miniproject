package com.example.hotel_management;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Date;
import java.util.ResourceBundle;

public class CheckInController implements Initializable{


    @FXML
    private TextField tb1;
    @FXML
    private TextField tb2;

    @FXML
    private TableView<tableview> tableview;

    @FXML
    private TableColumn<tableview, Integer> id;
    @FXML
    private TableColumn<tableview, String> dest;

    @FXML
    private TableColumn<tableview, String> name;

    @FXML
    private TableColumn<tableview, String> email;

    @FXML
    private TableColumn<tableview, Integer> phone;

    @FXML
    private TableColumn<tableview, String> idproof;

    @FXML
    private TableColumn<tableview, Date> in;

    @FXML
    private TableColumn<tableview, Date> out;

    @FXML
    private TableColumn<tableview, Integer> room;

    @FXML
    private TableColumn<tableview, Integer> total;


    final ObservableList<tableview>listview=FXCollections.observableArrayList();

    @Override

    public void initialize(URL url, ResourceBundle rb){

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        dest.setCellValueFactory(new PropertyValueFactory<>("dest"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        idproof.setCellValueFactory(new PropertyValueFactory<>("idproof"));
        in.setCellValueFactory(new PropertyValueFactory<>("Check_in"));
        out.setCellValueFactory(new PropertyValueFactory<>("Checkout"));
        room.setCellValueFactory(new PropertyValueFactory<>("room_no"));
        total.setCellValueFactory(new PropertyValueFactory<>("totalprice"));


        try
        {
            DatabaseConnection connectnow = new DatabaseConnection();
            Connection connectdb = connectnow.getconnection();
            PreparedStatement ps =connectdb.prepareStatement("select * from booking");
            ResultSet r= ps.executeQuery();


            while(r.next())
            {
                listview.add(new tableview(r.getString("id"),r.getString("dest"),r.getString("name"),r.getString("email"),r.getString("phone"),r.getString("idproof"),r.getString("check_in"),r.getString("checkout"),r.getString("rooms"),r.getString("totalprice")));
            }
            tableview.setItems(listview);

        }catch(SQLException e)
        {
            e.printStackTrace();

        }
    }


    @FXML
    void logout(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("loginpage.fxml"));

        ((Node) (event.getSource())).getScene().getWindow().hide();
        Scene scene = new Scene(fxmlLoader.load(), 455, 456);
        Stage stage = new Stage();
        stage.setTitle("login");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void check(ActionEvent event) {
        try {
            String n = tb1.getText();
            String idpr = tb2.getText();
            DatabaseConnection connectnow = new DatabaseConnection();
            Connection connectdb = connectnow.getconnection();
            Statement state = connectdb.createStatement();

            String delete = "delete from booking where name= '" + n + "' and Idproof= '" + idpr + "'";

            try {
                state.executeUpdate(delete);
                id.setCellValueFactory(new PropertyValueFactory<>("id"));
                dest.setCellValueFactory(new PropertyValueFactory<>("dest"));
                name.setCellValueFactory(new PropertyValueFactory<>("name"));
                email.setCellValueFactory(new PropertyValueFactory<>("email"));
                phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
                idproof.setCellValueFactory(new PropertyValueFactory<>("idproof"));
                in.setCellValueFactory(new PropertyValueFactory<>("Check_in"));
                out.setCellValueFactory(new PropertyValueFactory<>("Checkout"));
                room.setCellValueFactory(new PropertyValueFactory<>("room_no"));
                total.setCellValueFactory(new PropertyValueFactory<>("totalprice"));

                for ( int i = 0; i<tableview.getItems().size(); i++) {
                    tableview.getItems().clear();
                }
                try
                {

                    PreparedStatement ps =connectdb.prepareStatement("select * from booking");
                    ResultSet r= ps.executeQuery();


                    while(r.next())
                    {
                        listview.add(new tableview(r.getString("id"),r.getString("dest"),r.getString("name"),r.getString("email"),r.getString("phone"),r.getString("idproof"),r.getString("check_in"),r.getString("checkout"),r.getString("rooms"),r.getString("totalprice")));
                    }
                    tableview.setItems(listview);

                }catch(SQLException e)
                {
                    e.printStackTrace();

                }
            } catch (Exception ep) {
                ep.printStackTrace();
            } finally {

                state.close();
            }
        } catch(Exception ep) {
            ep.printStackTrace();
        }
    }

}
