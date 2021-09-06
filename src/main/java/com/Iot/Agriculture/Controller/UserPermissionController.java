package com.Iot.Agriculture.Controller;

import com.Iot.Agriculture.CommunicationServices.EmailService;
import com.Iot.Agriculture.DTO.UserPermissionDTO;
import com.Iot.Agriculture.Handlers.Exception.UserPermissionException;
import com.Iot.Agriculture.Model.UserPermissionDataModel;
import com.Iot.Agriculture.Repository.UserPermissionDataRepository;
import com.Iot.Agriculture.ResponseBuilder.ResponseBuilder;
import com.Iot.Agriculture.Service.UserDataServices;
import com.Iot.Agriculture.Service.UserPermissionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    @Autowired
    EmailService emailService;

    //add device....
    @GetMapping("/sendactivatedevicemail/{userid}/{deviceid}")
    public void sendDeviceActivationMail(@PathVariable("userid") int userId,@PathVariable("deviceid") int deviceid){
        emailService.sendDeviceActivationMail(userId,deviceid);
    }

    @GetMapping("/activatedevice/{userid}/{deviceid}")
    public UserPermissionDTO activateDevice(@PathVariable("userid") int userId, @PathVariable("deviceid") int deviceId){
        UserPermissionDataModel userPermissionDetails=userPermissionService.getUserPermissionDetails(userId);
        //valid user id or not..
        if((!userDataService.isUserAuthenticated(userId))
                ||(userPermissionDetails.getDeviceId()!=deviceId)
                || (userPermissionDetails.isDeviceActive())){
            throw new UserPermissionException();
        }
        userPermissionDetails.setDeviceId(userPermissionDetails.getDeviceId());
        userPermissionDetails.setDeviceActive(true);
        userPermissionDetails.setAbleToSaveData(true);
        return responseBuilder.buildUserPermissionDetails(userPermissionRepository.save(userPermissionDetails));
    }

    @GetMapping("/deactivatedevice/{userid}/{deviceid}")
    public UserPermissionDTO deactivateDevice(@PathVariable("userid") int userId,@PathVariable("deviceid") int deviceId){
        UserPermissionDataModel userPermissionDetails=userPermissionService.getUserPermissionDetails(userId);
        if((!userDataService.isUserAuthenticated(userId))
                ||(userPermissionDetails.getDeviceId()!=deviceId)
                || (!userPermissionDetails.isDeviceActive())){
            throw new UserPermissionException();
        }
        userPermissionDetails.setDeviceId(userPermissionDetails.getDeviceId());
        userPermissionDetails.setDeviceActive(false);
        userPermissionDetails.setAbleToSaveData(false);
        return responseBuilder.buildUserPermissionDetails(userPermissionRepository.save(userPermissionDetails));
    }
}
