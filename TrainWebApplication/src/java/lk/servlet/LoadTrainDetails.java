package lk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
import lk.entity.Traindetails;
import lk.train.ReceiveTrainDataSessionBeanRemote;

/**
 *
 * @author Kavindya Nirmani
 */
@WebServlet(name = "LoadTrainDetails", urlPatterns = {"/LoadTrainDetails"})
public class LoadTrainDetails extends HttpServlet {

//    @EJB
//    private ReceiveTrainDataSessionBeanRemote receiveTrainDataSessionBean1;

    ReceiveTrainDataSessionBeanRemote receiveTrainDataSessionBean = lookupReceiveTrainDataSessionBeanRemote();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("servlet 1");
        try {
            List<Traindetails> td = receiveTrainDataSessionBean.loadTrainData();
            System.out.println("servlet 2");
            for (Traindetails traindetails : td) {
                System.out.println("train id"+traindetails.getIdtraindetails());
                System.out.println("train code"+traindetails.getTraincode());
            }
            
            request.setAttribute("traindata", td);
            request.getRequestDispatcher("traindetailscontainer.jsp").forward(request, response);
        } catch (Exception e) {
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
