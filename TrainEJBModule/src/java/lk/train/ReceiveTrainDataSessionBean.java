package lk.train;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lk.entity.Traindetails;
import lk.entity.User;

/**
 *
 * @author Kavindya Nirmani
 */
@Stateless
public class ReceiveTrainDataSessionBean implements ReceiveTrainDataSessionBeanRemote, ReceiveTrainDataSessionBeanLocal {

    @PersistenceContext(unitName = "TrainEJBModulePU")
    EntityManager em;
    
    
    @Override
    public String loginmethod(String email, String password) {
        User user = (User)em.createQuery("SELECT u FROM User u WHERE u.email = '"+email.trim()+"'").getSingleResult();
        System.out.println("password : "+password);
        
        if (user.getEmail().equalsIgnoreCase(email)&& user.getPassword().equalsIgnoreCase(password)) {
            return "LOGIN SUCCESS";
        } else{
            return "LOGIN UNSUCCESS";
        }
    }

    @Override
    public List<Traindetails> loadTrainData() {
        List<Traindetails> traindetails = em.createQuery("SELECT t FROM Traindetails t").getResultList();
        System.out.println("datasize___"+traindetails.size());
        return traindetails;
    }
    
    
    
}
