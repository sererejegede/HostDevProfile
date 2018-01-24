/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serere.hostdevprofile;

import com.serere.hostdevprofile.auth.CountService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Test extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        CountService countService = new CountService();
        countService.put();
//        List<String> lang = countService.language();
//        for (String lan : lang) {
////          out.println(lan);
//            out.println(countService.update("third", "thirdLang", lan)); 
//        }
        

            
            // UPDATE choice SET first = (SELECT COUNT(*) FROM `dev_credentials` WHERE firstLang = 'PHP') WHERE choice_id = 2 
// UPDATE choice SET "+position1+" = (SELECT COUNT(*) FROM `dev_credentials` WHERE "+position2+" = '"+lang+"') WHERE choice_id = '"+index+"'
    }

    
    
   

}
