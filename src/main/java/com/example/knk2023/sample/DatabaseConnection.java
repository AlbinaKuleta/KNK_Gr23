package com.example.knk2023.sample;
import java.sql.Connection;
import java.sql.DriverManager;
public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection() {
        String databaseName = "albina";
        String databaseUser = "root";
        String databasePassword = "albinakuleta2003";
        String url = "jdbc:mysql://localhost:3306/albina";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);

        } catch (Exception e) {

            e.printStackTrace();

        }
        return databaseLink;
    }
}
