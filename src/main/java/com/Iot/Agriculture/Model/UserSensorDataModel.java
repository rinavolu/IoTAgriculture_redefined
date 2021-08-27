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
    private int env_temperature;
    private int area_temperature;
    private int humidity;
    private double dustDensity;
    private double moisturePercentage;
    private int uvLevel;
    private double uvIntensity;
    private Timestamp createdAt=Timestamp.valueOf(LocalDateTime.now());

    public int getEntryNo() {
        return EntryNo;
    }

    public void setEntryNo(int entryNo) {
        EntryNo = entryNo;
    }

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

    public int getEnv_temperature() {
        return env_temperature;
    }

    public void setEnv_temperature(int env_temperature) {
        this.env_temperature = env_temperature;
    }

    public int getArea_temperature() {
        return area_temperature;
    }

    public void setArea_temperature(int area_temperature) {
        this.area_temperature = area_temperature;
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

    public void setUvIntensity(double uvIntensity) {
        this.uvIntensity = uvIntensity;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
