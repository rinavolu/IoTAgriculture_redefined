package com.Iot.Agriculture.Service;

import com.Iot.Agriculture.Model.UserDeviceDetailsDataModel;

public interface UserDeviceService {
    UserDeviceDetailsDataModel getUserDeviceDetails(int userId);
}
