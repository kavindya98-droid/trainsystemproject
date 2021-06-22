/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kavindya Nirmani
 */
@Entity
@Table(name = "traindetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Traindetails.findAll", query = "SELECT t FROM Traindetails t")
    , @NamedQuery(name = "Traindetails.findByIdtraindetails", query = "SELECT t FROM Traindetails t WHERE t.idtraindetails = :idtraindetails")
    , @NamedQuery(name = "Traindetails.findByTraincode", query = "SELECT t FROM Traindetails t WHERE t.traincode = :traincode")
    , @NamedQuery(name = "Traindetails.findByLocation", query = "SELECT t FROM Traindetails t WHERE t.location = :location")
    , @NamedQuery(name = "Traindetails.findByTemperature", query = "SELECT t FROM Traindetails t WHERE t.temperature = :temperature")
    , @NamedQuery(name = "Traindetails.findBySpeed", query = "SELECT t FROM Traindetails t WHERE t.speed = :speed")
    , @NamedQuery(name = "Traindetails.findByHumidity", query = "SELECT t FROM Traindetails t WHERE t.humidity = :humidity")
    , @NamedQuery(name = "Traindetails.findByTraindate", query = "SELECT t FROM Traindetails t WHERE t.traindate = :traindate")
    , @NamedQuery(name = "Traindetails.findByTraintime", query = "SELECT t FROM Traindetails t WHERE t.traintime = :traintime")})
public class Traindetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtraindetails")
    private Integer idtraindetails;
    @Size(max = 75)
    @Column(name = "traincode")
    private String traincode;
    @Size(max = 45)
    @Column(name = "location")
    private String location;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "temperature")
    private Double temperature;
    @Column(name = "speed")
    private Double speed;
    @Size(max = 45)
    @Column(name = "humidity")
    private String humidity;
    @Size(max = 45)
    @Column(name = "traindate")
    private String traindate;
    @Size(max = 45)
    @Column(name = "traintime")
    private String traintime;

    public Traindetails() {
    }

    public Traindetails(Integer idtraindetails) {
        this.idtraindetails = idtraindetails;
    }

    public Integer getIdtraindetails() {
        return idtraindetails;
    }

    public void setIdtraindetails(Integer idtraindetails) {
        this.idtraindetails = idtraindetails;
    }

    public String getTraincode() {
        return traincode;
    }

    public void setTraincode(String traincode) {
        this.traincode = traincode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getTraindate() {
        return traindate;
    }

    public void setTraindate(String traindate) {
        this.traindate = traindate;
    }

    public String getTraintime() {
        return traintime;
    }

    public void setTraintime(String traintime) {
        this.traintime = traintime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtraindetails != null ? idtraindetails.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Traindetails)) {
            return false;
        }
        Traindetails other = (Traindetails) object;
        if ((this.idtraindetails == null && other.idtraindetails != null) || (this.idtraindetails != null && !this.idtraindetails.equals(other.idtraindetails))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lk.entity.Traindetails[ idtraindetails=" + idtraindetails + " ]";
    }
    
}
