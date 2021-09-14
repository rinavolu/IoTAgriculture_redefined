package com.Iot.Agriculture.DTO;

public class UserPermissionDTO {
    public int userId;
    public int deviceLimit;
    public boolean isEligibleForDevice;
    public int NoOfDevicesActive;

    public UserPermissionDTO(int userId, int deviceLimit, boolean isEligibleForDevice, int noOfDevicesActive) {
        this.userId = userId;
        this.deviceLimit = deviceLimit;
        this.isEligibleForDevice = isEligibleForDevice;
        NoOfDevicesActive = noOfDevicesActive;
    }
}
