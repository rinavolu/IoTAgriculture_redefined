package com.Iot.Agriculture.Model;

import javax.persistence.*;

@Entity
@Table(name="user_permissions")
public class UserPermissionDataModel {
    @Id
    @GeneratedValue
    private int slno;

    private int userId;
    private int deviceId=0;
    private boolean isAbleToSaveData=false;
    private boolean isDeviceActive=false;

    public UserPermissionDataModel() {
    }

    public UserPermissionDataModel(int userId, int deviceId, boolean isAbleToSaveData, boolean isDeviceActive) {
        this.userId = userId;
        this.deviceId = deviceId;
        this.isAbleToSaveData = isAbleToSaveData;
        this.isDeviceActive = isDeviceActive;
    }

    public UserPermissionDataModel(int userId) {
        this.userId = userId;
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

    public boolean isDeviceActive() {
        return isDeviceActive;
    }

    public void setDeviceActive(boolean deviceActive) {
        isDeviceActive = deviceActive;
    }

    public boolean isAbleToSaveData() {
        return isAbleToSaveData;
    }

    public void setAbleToSaveData(boolean ableToSaveData) {
        isAbleToSaveData = ableToSaveData;
    }
}
