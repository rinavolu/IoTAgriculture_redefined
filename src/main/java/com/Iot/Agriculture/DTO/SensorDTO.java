package com.Iot.Agriculture.DTO;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class SensorDTO {

    public int deviceId;
    public int temperature;
    public int humidity;
    public double dustDensity;
    public double moisturePercentage;
    public int uvLevel;
    public double uvIntensity;
    public Timestamp createdAt;

    public SensorDTO(int deviceId, int temperature, int humidity, double dustDensity, double moisturePercentage, int uvLevel, double uvIntensity, Timestamp createdAt) {
        this.deviceId = deviceId;
        this.temperature = temperature;
        this.humidity = humidity;
        this.dustDensity = dustDensity;
        this.moisturePercentage = moisturePercentage;
        this.uvLevel = uvLevel;
        this.uvIntensity = uvIntensity;
        this.createdAt = createdAt;
    }
}
