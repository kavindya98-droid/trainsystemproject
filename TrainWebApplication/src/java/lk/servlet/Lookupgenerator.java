/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.servlet;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import lk.train.ReceiveTrainDataSessionBeanRemote;

/**
 *
 * @author Kavindya Nirmani
 */
public class Lookupgenerator {

    ReceiveTrainDataSessionBeanRemote receiveTrainDataSessionBean = lookupReceiveTrainDataSessionBeanRemote();

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
