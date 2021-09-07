package com.Iot.Agriculture.DTO;

import javax.persistence.Column;

public class UserDeviceDetailsDTO {

    public int deviceId;
    public int userId;
    public String deviceName;
    public boolean isDeviceActive;

    public UserDeviceDetailsDTO(int deviceId, int userId, String deviceName, boolean isDeviceActive) {
        this.deviceId = deviceId;
        this.userId = userId;
        this.deviceName = deviceName;
        this.isDeviceActive = isDeviceActive;
    }
}
