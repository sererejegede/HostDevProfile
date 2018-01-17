package com.serere.hostdevprofile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    static {
        try {
            Class.forName(Constants.DRIVER);
        } catch (ClassNotFoundException e) {
        }
    }
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(Constants.DB_URL, Constants.DB_USERNAME, Constants.DB_PASSWORD);
    }
    
    public static Statement cStatement() throws SQLException{
        return getConnection().createStatement();
    }
}
