package com.Iot.Agriculture.ResponseBuilder;

import com.Iot.Agriculture.DTO.UserSensorDataDTO;
import com.Iot.Agriculture.Model.UserSensorDataModel;

import java.util.List;

public interface ResponseBuilder {

    List<UserSensorDataDTO> buildUserSensorData(List<UserSensorDataModel> userSensorDataModelList);
}
