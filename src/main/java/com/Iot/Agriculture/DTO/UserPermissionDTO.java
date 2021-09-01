package com.Iot.Agriculture.DTO;

public class UserPermissionDTO {
    public int deviceId;
    public boolean isDeviceActive;
    public boolean isAbleToSaveData;

    public UserPermissionDTO(int deviceId, boolean isDeviceActive, boolean isAbleToSaveData) {
        this.deviceId = deviceId;
        this.isDeviceActive = isDeviceActive;
        this.isAbleToSaveData = isAbleToSaveData;
    }
}
