package com.Iot.Agriculture.ResponseBuilder.Impl;

import com.Iot.Agriculture.DTO.*;
import com.Iot.Agriculture.Model.UserPermissionDataModel;
import com.Iot.Agriculture.Model.UserRegistrationDataModel;
import com.Iot.Agriculture.Model.UserSensorDataModel;
import com.Iot.Agriculture.ResponseBuilder.ResponseBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResponseBuilderImpl implements ResponseBuilder {

    @Override
    public List<UserSensorDataDTO> buildUserSensorData(List<UserSensorDataModel> userSensorDataModelList) {
        List<UserSensorDataDTO> userSensorDataResponse=new ArrayList<>();
        for(UserSensorDataModel data: userSensorDataModelList){
        SensorDTO sensorDTO=new SensorDTO(data.getDeviceId(),
                data.getEnv_temperature(),
                data.getEnv_temperature(),
                data.getHumidity(),
                data.getDustDensity(),
                data.getMoisturePercentage(),
                data.getUvLevel(),
                data.getUvIntensity(),
                data.getCreatedAt());
        UserSensorDataDTO userDTO=new UserSensorDataDTO(data.getUserId(),sensorDTO,data.getCreatedAt());
        userSensorDataResponse.add(userDTO);
        }
        return userSensorDataResponse;
    }

    @Override
    public UserRegistrationMainDTO buildRegisteredUserResponse(UserRegistrationDataModel registeredDetails, UserPermissionDataModel userPermissions) {
        UserPermissionDTO permissionResponse=new UserPermissionDTO(
                userPermissions.getDeviceId(),
                userPermissions.isDeviceActive());
        UserRegistrationMainDTO responseDTO=new UserRegistrationMainDTO(
                registeredDetails.getUserId(),
                registeredDetails.getFirstName(),
                registeredDetails.getLastName(),
                registeredDetails.getEmail(),
                registeredDetails.getPhoneNumber(),
                registeredDetails.isValidationExpired(),
                registeredDetails.isUserValidated(),
                permissionResponse,
                registeredDetails.getCreatedAt());
        return responseDTO;
    }

    @Override
    public UserDetailsDTO buildUserDetailsOnly(UserRegistrationDataModel registeredDetails) {
        UserDetailsDTO userDetails=new UserDetailsDTO(
                registeredDetails.getUserId(),
                registeredDetails.getFirstName(),
                registeredDetails.getLastName(),
                registeredDetails.getEmail(),
                registeredDetails.getPhoneNumber(),
                registeredDetails.isValidationExpired(),
                registeredDetails.isUserValidated(),
                registeredDetails.getCreatedAt()
        );
        return userDetails;
    }
}
