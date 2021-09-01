package com.Iot.Agriculture.Service;

import com.Iot.Agriculture.Model.UserPermissionDataModel;

public interface UserPermissionServices {

    boolean isUserHavePrivilege(int userId);
    UserPermissionDataModel getUserPermissionDetails(int userId);
}
