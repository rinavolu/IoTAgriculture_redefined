package com.Iot.Agriculture.Service;

import com.Iot.Agriculture.Model.UserSensorDataModel;

import java.util.List;

public interface DataServices {

    List<UserSensorDataModel> getSensorDataByUserId(int userId);
}
