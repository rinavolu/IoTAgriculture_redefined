package com.Iot.Agriculture.ResponseBuilder;

import com.Iot.Agriculture.DTO.*;
import com.Iot.Agriculture.Model.UserDeviceDetailsDataModel;
import com.Iot.Agriculture.Model.UserPermissionDataModel;
import com.Iot.Agriculture.Model.UserRegistrationDataModel;
import com.Iot.Agriculture.Model.UserSensorDataModel;

import java.util.List;

public interface ResponseBuilder {

    List<UserSensorDataDTO> buildUserSensorData(List<UserSensorDataModel> userSensorDataModelList);
    UserRegistrationMainDTO buildRegisteredUserResponse(UserRegistrationDataModel registeredDetails, UserPermissionDataModel userPermissions);
    UserDetailsDTO buildUserDetailsOnly(UserRegistrationDataModel registeredDetails);
    UserPermissionDTO buildUserPermissionDetails(UserPermissionDataModel userPermissionModel);
    UserDeviceDetailsDTO buildUserDeviceDetails(UserDeviceDetailsDataModel userDeviceModel);
}
