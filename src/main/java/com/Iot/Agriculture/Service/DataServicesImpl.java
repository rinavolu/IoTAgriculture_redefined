package com.Iot.Agriculture.Service;

import com.Iot.Agriculture.Model.UserSensorDataModel;
import com.Iot.Agriculture.Repository.SensorDataRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataServicesImpl implements DataServices{

    @Autowired
    private SensorDataRepository sensorDataRepository;

    @Override
    public List<UserSensorDataModel> getSensorDataByUserId(int userId) {
        List<UserSensorDataModel> sensorDataList=sensorDataRepository.findAll();
        List<UserSensorDataModel> userSensorDataModelList=new ArrayList<>();
        for(UserSensorDataModel i: sensorDataList)
        {
            if(i.getUserId()==userId){
                userSensorDataModelList.add(i);
            }
        }
        return userSensorDataModelList;
    }
}
