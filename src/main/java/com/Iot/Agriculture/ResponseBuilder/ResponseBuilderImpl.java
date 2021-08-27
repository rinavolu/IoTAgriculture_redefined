package com.Iot.Agriculture.ResponseBuilder;

import com.Iot.Agriculture.DTO.SensorDTO;
import com.Iot.Agriculture.DTO.UserSensorDataDTO;
import com.Iot.Agriculture.Model.UserSensorDataModel;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResponseBuilderImpl implements ResponseBuilder{

    @Override
    public List<UserSensorDataDTO> buildUserSensorData(List<UserSensorDataModel> userSensorDataModelList) {
        List<UserSensorDataDTO> userSensorDataResponse=new ArrayList<>();
        for(UserSensorDataModel data: userSensorDataModelList){
        SensorDTO sensorDTO=new SensorDTO(data.getDeviceId(),
                data.getEnv_temperature(), data.getEnv_temperature(), data.getHumidity(),
                data.getDustDensity(),data.getMoisturePercentage(),data.getUvLevel(),
                data.getUvIntensity(),data.getCreatedAt());
        UserSensorDataDTO userDTO=new UserSensorDataDTO(data.getUserId(),sensorDTO,data.getCreatedAt());
        userSensorDataResponse.add(userDTO);
        }
        return userSensorDataResponse;
    }
}
