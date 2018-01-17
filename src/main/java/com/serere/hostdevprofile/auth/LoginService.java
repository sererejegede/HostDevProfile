package com.serere.hostdevprofile.auth;

import java.sql.*;



public class LoginService {
    private int answer = 0;
    private String firstName;
    
    public int authenticate(String username, String password){
        try {
            Connection connection = com.serere.hostdevprofile.DBConnection.getConnection();
            Statement statement = com.serere.hostdevprofile.DBConnection.cStatement();
            
            String sql_check = "SELECT fname, username, password FROM dev_credentials WHERE username = '"+username+"'";
          
            
            ResultSet rs = statement.executeQuery(sql_check);
           
           if(rs.next()){
            if(username.equals(rs.getString("username"))){
             if(password.equals(rs.getString("password"))){
              answer = 1; // 1 means login success
             } else { answer = 2;} // 2 means Incorrect password
            } 
            
           }else { answer = 3;} // 3 means User doesn't exist
           
           rs.close();
           statement.close();
           connection.close();
        } catch (SQLException e) {
        }
        return answer;
    }
   
    public String firstName(String user){
        try {
            Connection connection = com.serere.hostdevprofile.DBConnection.getConnection();
            Statement statement = com.serere.hostdevprofile.DBConnection.cStatement();
            
            String sql_check = "SELECT fname, username, password FROM dev_credentials WHERE username = '"+user+"'";
            
            ResultSet reqset = statement.executeQuery(sql_check);
            reqset.next();
            firstName = reqset.getString("fname");
            
            
           reqset.close();
           statement.close();
           connection.close();
        } catch (Exception e) {
        }
        return firstName; 
    }
  
}
