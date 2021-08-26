package com.Iot.Agriculture.Service;

import com.Iot.Agriculture.Model.UserSensorDataModel;

import java.util.List;

/*
 * *****************************
 *  By: Ravindranadh Inavolu
 * *****************************
 * */
public interface DataServices {

    List<UserSensorDataModel> getSensorDataByUserId(int userId);
}
