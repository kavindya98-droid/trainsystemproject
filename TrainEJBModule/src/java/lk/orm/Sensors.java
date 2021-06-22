/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.orm;

/**
 *
 * @author Kavindya Nirmani
 */
public class Sensors {

    public Sensors() {
    }

    public Sensors(int idtraindetails, String traincode, String location, double temperature, double speed, String humidity, String traindate, String traintime) {
        this.idtraindetails = idtraindetails;
        this.traincode = traincode;
        this.location = location;
        this.temperature = temperature;
        this.speed = speed;
        this.humidity = humidity;
        this.traindate = traindate;
        this.traintime = traintime;
    }
    
    
    
    private int idtraindetails;
    private String traincode;
    private String location;
    private double temperature;
    private double speed;
    private String humidity;
    private String traindate;
    private String traintime;
    /**
     * @return the idtraindetails
     */
    public int getIdtraindetails() {
        return idtraindetails;
    }

    /**
     * @param idtraindetails the idtraindetails to set
     */
    public void setIdtraindetails(int idtraindetails) {
        this.idtraindetails = idtraindetails;
    }

    /**
     * @return the traincode
     */
    public String getTraincode() {
        return traincode;
    }

    /**
     * @param traincode the traincode to set
     */
    public void setTraincode(String traincode) {
        this.traincode = traincode;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the temperature
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * @param temperature the temperature to set
     */
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    /**
     * @return the speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * @return the humidity
     */
    public String getHumidity() {
        return humidity;
    }

    /**
     * @param humidity the humidity to set
     */
    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    /**
     * @return the traindate
     */
    public String getTraindate() {
        return traindate;
    }

    /**
     * @param traindate the traindate to set
     */
    public void setTraindate(String traindate) {
        this.traindate = traindate;
    }

    /**
     * @return the traintime
     */
    public String getTraintime() {
        return traintime;
    }

    /**
     * @param traintime the traintime to set
     */
    public void setTraintime(String traintime) {
        this.traintime = traintime;
    }
}
