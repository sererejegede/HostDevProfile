package com.serere.hostdevprofile.auth;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.serere.hostdevprofile.Constants;

public class StatisticsService {
    private int count;
    int[] result;
    
    int[] countArray = new int[15];
    String[] countLanguages = new String[15];
    
    List languagesList = new ArrayList();
    List<Integer> languagesCount = new ArrayList();
    
    public List<Integer> counter(String lang){
        try {
            
            Connection connection = com.serere.hostdevprofile.DBConnection.getConnection();
            Statement statement = com.serere.hostdevprofile.DBConnection.cStatement();
            
//            String sql_beta = "SELECT COUNT(*) AS 'count' FROM dev_credentials GROUP BY "+lang+" ORDER BY COUNT(*) DESC";
//            ResultSet resul = statement.executeQuery(sql_beta);
//            while(resul.next()){
//            languagesCount.add(resul.getInt("count"));
//            }
            
            String sql_beta = "SELECT "+lang+" FROM `choice` ORDER BY firstLang DESC";
            ResultSet resul = statement.executeQuery(sql_beta);
            while(resul.next()){
            languagesCount.add(resul.getInt(lang));
            }
          
        resul.close();
        statement.close();
        connection.close();    
        } catch (Exception e) {
        }
        
     return languagesCount;   
    }
    
    
    public List<String> languageReturn(){
        try {
            Connection connection = com.serere.hostdevprofile.DBConnection.getConnection();
            Statement statement = com.serere.hostdevprofile.DBConnection.cStatement();
            
//            String sql1 = "SELECT "+lang+" FROM dev_credentials GROUP BY firstLang ORDER BY COUNT("+lang+") DESC";
//            
//            ResultSet res = statement.executeQuery(sql1);
//            
//            while(res.next()){
//                languagesList.add(res.getString("firstLang"));
//            }

            String sql = "SELECT prog_name FROM choice ORDER BY firstLang DESC";
            ResultSet res = statement.executeQuery(sql);
            while(res.next()){
                languagesList.add(res.getString("prog_name"));
            }
        res.close();
        statement.close();
        connection.close();    
        } catch (Exception e) {
        }
        
     return languagesList;   
    }
    
    public int[] reverse(int[] list) {
    result = new int[list.length];

   for (int i = 0, j = result.length - 1; i < list.length; i++, j--) {
      result[j] = list[i];
      
   }
   
   return result;
}
    
 
}
