package com.Iot.Agriculture.Service.Impl;

import com.Iot.Agriculture.Handlers.Exception.InValidDeviceException;
import com.Iot.Agriculture.Model.UserDeviceDetailsDataModel;
import com.Iot.Agriculture.Repository.UserDeviceDataRepository;
import com.Iot.Agriculture.Service.UserDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDeviceServiceImpl implements UserDeviceService {

    @Autowired
    UserDeviceDataRepository deviceRepo;

    @Override
    public UserDeviceDetailsDataModel getUserDeviceDetails(int userId) {
        List<UserDeviceDetailsDataModel> deviceDetails=deviceRepo.findAll();
        for(UserDeviceDetailsDataModel i:deviceDetails){
            if(i.getUserId()==userId)
                return i;
        }
        throw new InValidDeviceException();
    }
}
