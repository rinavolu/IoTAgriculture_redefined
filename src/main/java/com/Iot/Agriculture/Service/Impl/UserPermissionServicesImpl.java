package com.Iot.Agriculture.Service.Impl;

import com.Iot.Agriculture.Handlers.Exception.UserNotFoundException;
import com.Iot.Agriculture.Model.UserPermissionDataModel;
import com.Iot.Agriculture.Repository.UserPermissionDataRepository;
import com.Iot.Agriculture.Service.UserPermissionServices;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserPermissionServicesImpl implements UserPermissionServices {

    @Autowired
    UserPermissionDataRepository userPermissionRepository;

    @Override
    public boolean isUserHavePrivilege(int userId) {
        List<UserPermissionDataModel> userDetails=userPermissionRepository.findAll();
        for(UserPermissionDataModel i:userDetails){
            if(i.getUserId()==userId){
                return i.isAbleToSaveData()&&i.isDeviceActive();
            }
        }
        throw new UserNotFoundException();
    }

    @Override
    public UserPermissionDataModel getUserPermissionDetails(int userId) {
        List<UserPermissionDataModel> userDetails=userPermissionRepository.findAll();
        for(UserPermissionDataModel i:userDetails){
            if(i.getUserId()==userId){
                return i;
            }
        }
        throw new UserNotFoundException();
    }
}
