package com.Iot.Agriculture.Service;

import com.Iot.Agriculture.Model.UserPermissionDataModel;
import com.Iot.Agriculture.Model.UserRegistrationDataModel;

public interface UserDataServices {

    UserPermissionDataModel saveUserPermissionDetails(UserRegistrationDataModel userRegistration);

    UserRegistrationDataModel getUserDetails(int userId);

    boolean isUserAuthenticated(int userId);
}
