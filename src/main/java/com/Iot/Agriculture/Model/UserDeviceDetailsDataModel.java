package com.Iot.Agriculture.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name="user_device_details")
public class UserDeviceDetailsDataModel {

    @Id
    @GeneratedValue
    private int deviceId;

    @Column(unique = true)
    private int userId;

    private String deviceName;
    private boolean isDeviceActive=false;
    private Timestamp createdAt=Timestamp.valueOf(LocalDateTime.now());

    public UserDeviceDetailsDataModel(int userId, String deviceName) {
        this.userId = userId;
        this.deviceName = deviceName;
    }

    public UserDeviceDetailsDataModel() {
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public boolean isDeviceActive() {
        return isDeviceActive;
    }

    public void setDeviceActive(boolean deviceActive) {
        isDeviceActive = deviceActive;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
