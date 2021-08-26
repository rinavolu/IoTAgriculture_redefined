package com.Iot.Agriculture.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name="user_sensor_data")
public class UserSensorDataModel {

    @Id
    @GeneratedValue
    private int EntryNo;
    private int userId;
    private int deviceId;
    private int temperature;
    private int humidity;
    private double dustDensity;
    private double moisturePercentage;
    private int uvLevel;
    private double uvIntensity;
    private Timestamp createdAt=Timestamp.valueOf(LocalDateTime.now());

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getDustDensity() {
        return dustDensity;
    }

    public void setDustDensity(double dustDensity) {
        this.dustDensity = dustDensity;
    }

    public double getMoisturePercentage() {
        return moisturePercentage;
    }

    public void setMoisturePercentage(double moisturePercentage) {
        this.moisturePercentage = moisturePercentage;
    }

    public int getUvLevel() {
        return uvLevel;
    }

    public void setUvLevel(int uvLevel) {
        this.uvLevel = uvLevel;
    }

    public double getUvIntensity() {
        return uvIntensity;
    }

    public void setUvIntensity(int uvIntensity) {
        this.uvIntensity = uvIntensity;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
