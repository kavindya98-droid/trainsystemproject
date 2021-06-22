/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lk.train.ReceiveTrainDataSessionBeanRemote;

/**
 *
 * @author Kavindya Nirmani
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

//    @EJB
//    private ReceiveTrainDataSessionBeanRemote receiveTrainDataSessionBean;
    
    ReceiveTrainDataSessionBeanRemote receiveTrainDataSessionBean = lookupReceiveTrainDataSessionBeanRemote();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        String result = receiveTrainDataSessionBean.loginmethod(email,password);
        
        if (result.equals("LOGIN SUCCESS")) {
            System.out.println("OK");
            response.getWriter().write("OK");
        } else if (result.equals("LOGIN UNSUCCESS")) {
            System.out.println("NOT OK");
            response.getWriter().write("NOT OK");
        } else{
            System.out.println("ERROR");
            response.getWriter().write("ERROR");
        }
    }
    

    private ReceiveTrainDataSessionBeanRemote lookupReceiveTrainDataSessionBeanRemote() {
        try {
            Context c = new InitialContext();
            return (ReceiveTrainDataSessionBeanRemote) c.lookup("java:global/TrainEJBModule/ReceiveTrainDataSessionBean!lk.train.ReceiveTrainDataSessionBeanRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
