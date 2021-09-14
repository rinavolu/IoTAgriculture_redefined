package com.Iot.Agriculture.Service.Impl;

import com.Iot.Agriculture.Handlers.Exception.InValidVerificationIdException;
import com.Iot.Agriculture.Handlers.Exception.UserPermissionException;
import com.Iot.Agriculture.Model.UserDeviceDetailsDataModel;
import com.Iot.Agriculture.Model.UserPermissionDataModel;
import com.Iot.Agriculture.Model.UserRegistrationDataModel;
import com.Iot.Agriculture.Model.UserSensorDataModel;
import com.Iot.Agriculture.Repository.UserDeviceDataRepository;
import com.Iot.Agriculture.Service.UserDataServices;
import com.Iot.Agriculture.Service.UserDeviceService;
import com.Iot.Agriculture.Service.UserPermissionServices;
import com.Iot.Agriculture.Service.UserValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserValidationServiceImpl implements UserValidationService {

    @Autowired
    private UserDataServices userDataService;
    @Autowired
    UserPermissionServices userPermissionService;
    @Autowired
    UserDeviceService deviceService;

    @Override
    public boolean UserValidationCheck_Authentication(int userId, String verificationId) {
        //if user not present
        UserRegistrationDataModel userDetails =userDataService.getUserDetails(userId);
        if(userDetails.isUserValidated()){
            throw new RuntimeException("User Already Authenticated");
        }
        if(!(userDetails.getValidationId().equals(verificationId))){
            throw new InValidVerificationIdException();
        }
        return true;
    }

    @Override
    public boolean UserValidationCheck_AddDevice(int userId) {
        //isuserpresent
        UserRegistrationDataModel userDetails=userDataService.getUserDetails(userId);
        // isuserauthenticated
        if(!userDetails.isUserValidated()){
            throw new UserPermissionException();
        }
        //isusereligiblefordevice
        UserPermissionDataModel permissionDetails = userPermissionService.getUserPermissionDetails(userId);
        if(!permissionDetails.isEligibleForDevice()){
             throw new UserPermissionException();
         }
        //isuserdevicelimit and active devices check
        if(permissionDetails.getNoOfDevicesActive()+ permissionDetails.getNoOfDevicesNotActive()== permissionDetails.getDeviceLimit())
        {
            throw new RuntimeException("Limit exceeded");
        }
        return true;
    }

    @Override
    public boolean UserValidationCheck_SaveSensorData(UserSensorDataModel sensorData) {
        //isuserpresent
        UserRegistrationDataModel userDetails=userDataService.getUserDetails(sensorData.getUserId());
        // isuserauthenticated
        if(!userDetails.isUserValidated()){
            throw new UserPermissionException();
        }

        /*isusereligiblefordevice  [NOT NEEDED]
        UserPermissionDataModel permissionDetails = userPermissionService.getUserPermissionDetails(sensorData.getUserId());
        if(!permissionDetails.isEligibleForDevice()){
            throw new UserPermissionException();
        }*/

        //is device present or not (internal call check)
        UserDeviceDetailsDataModel userDeviceDetails=deviceService.getUserDeviceDetails(sensorData.getUserId());
        //is device active or not
        if(!userDeviceDetails.isDeviceActive()){
            throw new RuntimeException("Device not active");
        }
        return true;
    }

    @Override
    public boolean UserValidationCheck_GetSensorData(int userId) {
        //isuserpresent
        UserRegistrationDataModel userDetails=userDataService.getUserDetails(userId);
        // isuserauthenticated
        if(!userDetails.isUserValidated()){
            throw new UserPermissionException();
        }
        return true;
    }
}
