package com.Iot.Agriculture.Service.Impl;

import com.Iot.Agriculture.Handlers.Exception.UserNotFoundException;
import com.Iot.Agriculture.Model.UserPermissionDataModel;
import com.Iot.Agriculture.Model.UserRegistrationDataModel;
import com.Iot.Agriculture.Repository.UserPermissionDataRepository;
import com.Iot.Agriculture.Repository.UserRegistrationDataRepository;
import com.Iot.Agriculture.ResponseBuilder.ResponseBuilder;
import com.Iot.Agriculture.Service.UserDataServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDataServicesImpl implements UserDataServices {

    @Autowired
    private UserPermissionDataRepository permissionRepository;
    @Autowired
    private UserRegistrationDataRepository userDataRepository;

    @Autowired
    private ResponseBuilder responseBuilder;

    @Override
    public UserPermissionDataModel saveUserPermissions_Authenticated(UserRegistrationDataModel userRegistration) {
        UserPermissionDataModel permissionObject=
                new UserPermissionDataModel(userRegistration.getUserId(),true);
        return permissionRepository.save(permissionObject);
    }

    @Override
    public UserRegistrationDataModel getUserDetails(int userId) {
        return getUserRegistrationDetails(userId);
    }

    @Override
    public boolean isUserAuthenticated(int userId){
        return getUserRegistrationDetails(userId).isUserValidated();
    }

    public UserRegistrationDataModel getUserRegistrationDetails(int userId){
        List<UserRegistrationDataModel> allUsers=userDataRepository.findAll();
        for(UserRegistrationDataModel i:allUsers){
            if(i.getUserId()==userId){
                return i;
            }
        }
        throw new UserNotFoundException();
    }

    public UserPermissionDataModel getUserPermissionDetails(int userId){
        List<UserPermissionDataModel> allUserPermissions=permissionRepository.findAll();
        for(UserPermissionDataModel i: allUserPermissions){
            if(i.getUserId()==userId)
                return i;
        }
        return null;
    }


}
