package com.Iot.Agriculture.Controller;

import com.Iot.Agriculture.DTO.UserPermissionDTO;
import com.Iot.Agriculture.Handlers.Exception.UserPermissionException;
import com.Iot.Agriculture.Model.UserPermissionDataModel;
import com.Iot.Agriculture.Repository.UserPermissionDataRepository;
import com.Iot.Agriculture.ResponseBuilder.ResponseBuilder;
import com.Iot.Agriculture.Service.UserDataServices;
import com.Iot.Agriculture.Service.UserPermissionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class UserPermissionController {

    @Autowired
    UserPermissionDataRepository userPermissionRepository;

    @Autowired
    ResponseBuilder responseBuilder;

    @Autowired
    UserDataServices userDataService;
    @Autowired
    UserPermissionServices userPermissionService;

    @PostMapping("/activatedevice/{userid}/{deviceid}")
    public UserPermissionDTO activateDevice(@PathVariable("userid") int userId, @PathVariable("deviceid") int deviceId){
        //valid user id or not..
        if(!userDataService.isUserAuthenticated(userId)){
            throw new UserPermissionException();
        }
        UserPermissionDataModel userPermissionDetails=userPermissionService.getUserPermissionDetails(userId);
        userPermissionDetails.setDeviceId(deviceId);
        userPermissionDetails.setDeviceActive(true);
        userPermissionDetails.setAbleToSaveData(true);
        return responseBuilder.buildUserPermissionDetails(userPermissionRepository.save(userPermissionDetails));
    }
}
