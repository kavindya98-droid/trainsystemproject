/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Kavindya Nirmani
 */
public class Send {
    public String sendJMSMessageToEJB(String text) throws JMSException, NamingException {
        Context c = new InitialContext();
        ConnectionFactory ConnectionFactory = (ConnectionFactory) c.lookup("jms/trainsystemfactory");
        Connection conn = null;
        Session session = null;
        try {
            conn = ConnectionFactory.createConnection();
            // conn.setClientID("WEBconsumer");
            session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue myqueue = (Queue) c.lookup("trainsystem");
            MessageProducer producer=session.createProducer(myqueue);
            conn.start();
            TextMessage message = session.createTextMessage(text);
            System.out.println("Message:"+message);
           producer.send(message);
 
           
        }catch(Exception e){
        e.printStackTrace();
        }
         return "Message send";
 
}

}
