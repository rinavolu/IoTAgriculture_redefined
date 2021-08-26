package com.Iot.Agriculture.DTO;

import java.sql.Timestamp;

public class UserSensorDataDTO {

    public int memberId;
    public SensorDTO sensorData;
    public Timestamp createdAt;

    public UserSensorDataDTO(int memberId, SensorDTO sensorData, Timestamp createdAt) {
        this.memberId = memberId;
        this.sensorData = sensorData;
        this.createdAt = createdAt;
    }
}
