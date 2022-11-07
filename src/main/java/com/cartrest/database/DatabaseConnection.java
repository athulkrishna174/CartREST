package com.cartrest.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    private String url = "jdbc:mysql://localhost:3306/cart";
    private String user = "root";
    private String password = "root";
    private Connection con;
    
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,user,password);
        } catch (SQLException | ClassNotFoundException e) {

            e.printStackTrace();
        }
        return con;
    }
}
