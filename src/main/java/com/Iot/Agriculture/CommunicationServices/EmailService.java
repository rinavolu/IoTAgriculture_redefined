package com.Iot.Agriculture.CommunicationServices;

import com.Iot.Agriculture.Model.UserRegistrationDataModel;

public interface EmailService {

    void sendUserAuthentication(UserRegistrationDataModel userDetails);
    void sendDeviceActivationMail(int userId,int deviceId);
}
