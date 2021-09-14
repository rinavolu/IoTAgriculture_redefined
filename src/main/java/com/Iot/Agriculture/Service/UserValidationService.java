package com.Iot.Agriculture.Service;

import com.Iot.Agriculture.Model.UserDeviceDetailsDataModel;
import com.Iot.Agriculture.Model.UserSensorDataModel;

public interface UserValidationService {

    boolean UserValidationCheck_Authentication(int userId,String verificationId);
    boolean UserValidationCheck_AddDevice(int userId);
    boolean UserValidationCheck_SaveSensorData(UserSensorDataModel sensorData);
    boolean UserValidationCheck_GetSensorData(int userId);
}
