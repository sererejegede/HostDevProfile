package com.serere.hostdevprofile;

import com.google.gson.Gson;
import com.serere.hostdevprofile.auth.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Main extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }
    
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        
        String first = request.getParameter("first");
        String second = request.getParameter("second");
        String third = request.getParameter("third");
        
        
        
        String fname = request.getParameter("firstname");
        String lname = request.getParameter("lastname");
        String userName = request.getParameter("usernameR");
        String passWord = request.getParameter("passwordR");
        
        DataAddService dataAdd = new DataAddService();
        CountService countService = new CountService();
        
        StatisticsService statisticsService = new StatisticsService();
        
        
             //////////        LOGIN         ////////
        if ("".equals(name) && "".equals(password)) {
            out.write("You must fill all fields");
        }
        else if (name != null && password != null) {
            
        LoginService loginService = new LoginService();
        int result = loginService.authenticate(name, password);
        
       
        switch (result) {
            case 1:
                if (!"".equals(first) && first != null){
                    
                    dataAdd.addLanguage(first, second, third, name);
                    countService.put();
                }
                 
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(statisticsService.finalAnswer());

                break;
            case 2:
                
                response.setContentType("text/plain");
                response.getWriter().write("Incorrect Password!");
                break;
            case 3:
                response.setContentType("text/plain");
                response.getWriter().write("User does not exist!");
                break;
            default:
                break;

        }    
        }
        
        //////////        REGISTRATION         ////////
        if ("".equals(fname) || "".equals(lname) || "".equals(userName) || "".equals(passWord)) {
            out.write("You must fill all fields");
        }
        else if (fname != null && lname != null) {
            
        
        RegistrationService registrationService = new RegistrationService();
        int register = registrationService.registerer(fname, lname, userName, passWord);
        
            if (register == 0) {
                response.setContentType("text/plain");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("User already exist");
            }else if (register == 1) {
                if (!"".equals(first) && first != null){
                    
                    dataAdd.addLanguage(first, second, third, userName);
                    countService.put();
                }
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(statisticsService.finalAnswer());
            }
        }
        

             
    }
}
