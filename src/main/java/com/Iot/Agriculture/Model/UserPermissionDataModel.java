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
    private boolean isDeviceActive=false;

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
}
