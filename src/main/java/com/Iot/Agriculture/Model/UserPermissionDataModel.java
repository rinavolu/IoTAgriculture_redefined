package com.Iot.Agriculture.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name="user_permissions")
public class UserPermissionDataModel {
    @Id
    @GeneratedValue
    private int slno;

    private int userId;
    private int deviceLimit=1;
    private boolean isEligibleForDevice=false;
    private int noOfDevicesActive=0;
    private int noOfDevicesNotActive=0;
    private Timestamp createdAt=Timestamp.valueOf(LocalDateTime.now());

    public UserPermissionDataModel() {
    }

    public UserPermissionDataModel(int userId, boolean isEligibleForDevice) {
        this.userId = userId;
        this.isEligibleForDevice = isEligibleForDevice;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDeviceLimit() {
        return deviceLimit;
    }

    public void setDeviceLimit(int deviceLimit) {
        this.deviceLimit = deviceLimit;
    }

    public boolean isEligibleForDevice() {
        return isEligibleForDevice;
    }

    public void setEligibleForDevice(boolean eligibleForDevice) {
        isEligibleForDevice = eligibleForDevice;
    }

    public int getNoOfDevicesActive() {
        return noOfDevicesActive;
    }

    public void setNoOfDevicesActive(int noOfDevicesActive) {
        this.noOfDevicesActive = noOfDevicesActive;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public int getNoOfDevicesNotActive() {
        return noOfDevicesNotActive;
    }

    public void setNoOfDevicesNotActive(int noOfDevicesNotActive) {
        this.noOfDevicesNotActive = noOfDevicesNotActive;
    }
}
