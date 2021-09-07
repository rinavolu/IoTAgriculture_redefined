package com.Iot.Agriculture.Service.Impl;

import com.Iot.Agriculture.Handlers.Exception.InValidVerificationIdException;
import com.Iot.Agriculture.Handlers.Exception.UserPermissionException;
import com.Iot.Agriculture.Model.UserDeviceDetailsDataModel;
import com.Iot.Agriculture.Model.UserPermissionDataModel;
import com.Iot.Agriculture.Model.UserRegistrationDataModel;
import com.Iot.Agriculture.Service.UserDataServices;
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
}
