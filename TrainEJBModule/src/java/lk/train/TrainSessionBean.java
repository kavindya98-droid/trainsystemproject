/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.train;

import com.google.gson.Gson;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.ejb.Singleton;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lk.entity.Traindetails;
import lk.orm.Sensors;

/**
 *
 * @author Kavindya Nirmani
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup",
            propertyValue = "trainsystem")
    ,
    @ActivationConfigProperty(propertyName = "destinationType",
            propertyValue = "javax.jms.Queue")
})

@Singleton
public class TrainSessionBean implements TrainSessionBeanRemote, MessageListener {

    @PersistenceContext(unitName = "TrainEJBModulePU")
    EntityManager em;

    @Resource
    private MessageDrivenContext mdc;

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {

                String s = message.getBody(String.class);
                Gson g = new Gson();
                Sensors p = g.fromJson(s, Sensors.class);

                System.out.println("traincode:" + p.getTraincode());
                System.out.println("location:" + p.getLocation());
                System.out.println("temperature:" + p.getTemperature());
                System.out.println("speed:" + p.getSpeed());
                System.out.println("humidity:" + p.getHumidity());
                System.out.println("traidate:" + p.getTraindate());
                System.out.println("traintime:" + p.getTraintime());

                String traincode = p.getTraincode();
                String location = p.getLocation();
                double speedfiled = p.getSpeed();
                double temperature = p.getTemperature();
                String humidity = p.getHumidity();
                String traindate = p.getTraindate();
                String traintime = p.getTraintime();

                Traindetails td = new Traindetails();
                td.setTraincode(traincode);
                td.setLocation(location);
                td.setSpeed(speedfiled);
                td.setHumidity(humidity);
                td.setTemperature(temperature);
                td.setTraindate(traindate);
                td.setTraintime(traintime);
                
                em.persist(td);
                em.flush();
            } else {
                System.out.println("not a message");
            }
        } catch (JMSException ex) {
            Logger.getLogger(TrainSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Add business logic below. (Right-click in editor and choose
        // "Insert Code > Add Business Method")
    }
}
