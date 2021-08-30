package com.Iot.Agriculture.DTO;

public class UserPermissionDTO {
    public int deviceId;
    public boolean isDeviceActive;

    public UserPermissionDTO(int deviceId, boolean isDeviceActive) {
        this.deviceId = deviceId;
        this.isDeviceActive = isDeviceActive;
    }
}
