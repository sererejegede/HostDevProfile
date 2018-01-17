package com.serere.hostdevprofile.auth;

import java.sql.*;

public class DataAddService {
    
    public void addLanguage(String first, String second, String third, String anothername){
        try {
            Connection connection = com.serere.hostdevprofile.DBConnection.getConnection();
            Statement statement = com.serere.hostdevprofile.DBConnection.cStatement();
            
            String sql_preference = "UPDATE dev_credentials SET firstLang = '"+first+"', secondLang = '"+second+"', thirdLang = '"+third+"' WHERE username = '"+anothername+"'";
            
            statement.execute(sql_preference);
            
            statement.close();
            connection.close();
            
        } catch (Exception e) {
        }
    }
}