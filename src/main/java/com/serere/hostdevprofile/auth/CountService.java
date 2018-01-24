package com.serere.hostdevprofile.auth;

import com.serere.hostdevprofile.Constants;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountService {
    
    List<String> languages = new ArrayList();
    int up;
    
    public List<String> language(){
        try {
            Connection connection = com.serere.hostdevprofile.DBConnection.getConnection();
            Statement statement = com.serere.hostdevprofile.DBConnection.cStatement();
            
            String sql = "SELECT prog_name FROM choice";
            ResultSet res = statement.executeQuery(sql);
            
            while(res.next()){
            languages.add(res.getString("prog_name"));
//            count = resul.getInt("count");
            }
            
        res.close();
        statement.close();
        connection.close();
        } catch (Exception e) {
        }
        return languages;
    } 
    
    public int update(String position1, String position2, String lang){
        
        try {
            Connection connection = com.serere.hostdevprofile.DBConnection.getConnection();
            Statement statement = com.serere.hostdevprofile.DBConnection.cStatement();
            
            String sql = "UPDATE choice SET "+position1+" = (SELECT COUNT(*) FROM `dev_credentials` WHERE "+position2+" = '"+lang+"') WHERE prog_name = '"+lang+"'";
            up = statement.executeUpdate(sql);
            
//        UPDATE choice
//SET first = (
//SELECT COUNT(*) FROM `dev_credentials` WHERE firstLang='Java')
        statement.close();
        connection.close();
        } catch (Exception e) {
        }
        
        return up;
    }
    
    public void put(){
        
        List<String> lang = this.language();
        for (String table : Constants.TABLE2) {
            for (String lan : lang) {
//          out.println(lan);
            this.update(table, table, lan); 
        }
        }
        
    }
}
