/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.train;

import java.util.List;
import javax.ejb.Remote;
import lk.entity.Traindetails;

/**
 *
 * @author Kavindya Nirmani
 */
@Remote
public interface ReceiveTrainDataSessionBeanRemote {

    String loginmethod(String email, String password);

    List<Traindetails> loadTrainData();
    
}
