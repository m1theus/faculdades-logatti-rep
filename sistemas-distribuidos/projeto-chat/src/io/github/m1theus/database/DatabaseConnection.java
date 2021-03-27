package io.github.m1theus.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static final String CONNECTION_URL = "jdbc:mysql://localhost/chatdb?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
