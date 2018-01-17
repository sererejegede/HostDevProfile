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
//        response.getWriter().write("Testing Main");
               
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

        
        
        if (name != null && password != null) {
            
        LoginService loginService = new LoginService();
        int result = loginService.authenticate(name, password);
        String firstName = loginService.firstName(name);
        
        StatisticsService statisticsService = new StatisticsService();
                List<String> countList = statisticsService.languageReturn("firstLang");
//                List<String> countList2 = statisticsService.languageReturn("secondLang");
//                List<String> countList3 = statisticsService.languageReturn("thirdLang");
                List<Integer> counts = statisticsService.counter("firstLang");
                List<Integer> counts2 = statisticsService.counter("secondLang");
                List<Integer> counts3 = statisticsService.counter("thirdLang");
                
                String countL = gson.toJson(countList);
//                String countL = gson.toJson(countList);
//                String countL2 = counts2.toString();
//                String countL3 = counts3.toString();
                String counted = gson.toJson(counts);
                String counted2 = gson.toJson(counts2);
                String counted3 = gson.toJson(counts3);
                
                String forSending = "["+countL+","+counted+","+counted2+","+counted3+"]";

                
       
        switch (result) {
            case 1:
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(forSending);
//                response.setContentType("text/plain");
//                response.setCharacterEncoding("UTF-8");
//                response.getWriter().write(forSending);

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
        
        if (fname != null && lname != null) {
            
        
        RegistrationService registrationService = new RegistrationService();
        int register = registrationService.registerer(fname, lname, userName, passWord);
            if (register == 0) {
                response.setContentType("text/plain");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("User already exists");
            }else if (register == 1) {
                response.setContentType("text/plain");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("Acount Created");
            }
        }
        
        if (first != null && second != null && third != null) {
            
            DataAddService dataAdd = new DataAddService();
            dataAdd.addLanguage(first, second, third, name);
        }

      
    }
}
