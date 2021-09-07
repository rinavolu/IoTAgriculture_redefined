package com.Iot.Agriculture.Service;

import com.Iot.Agriculture.Model.UserDeviceDetailsDataModel;

public interface UserValidationService {

    boolean UserValidationCheck_Authentication(int userId,String verificationId);
    boolean UserValidationCheck_AddDevice(int userId);
}
