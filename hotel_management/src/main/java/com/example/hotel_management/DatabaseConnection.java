package com.example.hotel_management;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConnection {
    public Connection databaselink;

    public Connection getconnection() {
        String databaseName = "hotel_manage";
        String databaseUser = "root";
        String databasePass = "Anushka_1922";
        String url = "jdbc:mysql://localhost:3306/" + databaseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaselink=DriverManager.getConnection(url,databaseUser,databasePass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return databaselink;
    }
}
