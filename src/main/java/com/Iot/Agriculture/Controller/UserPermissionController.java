package com.Iot.Agriculture.Controller;

import com.Iot.Agriculture.CommunicationServices.EmailService;
import com.Iot.Agriculture.DTO.UserDeviceDetailsDTO;
import com.Iot.Agriculture.DTO.UserPermissionDTO;
import com.Iot.Agriculture.Model.UserDeviceDetailsDataModel;
import com.Iot.Agriculture.Model.UserPermissionDataModel;
import com.Iot.Agriculture.Repository.UserDeviceDataRepository;
import com.Iot.Agriculture.Repository.UserPermissionDataRepository;
import com.Iot.Agriculture.ResponseBuilder.ResponseBuilder;
import com.Iot.Agriculture.Service.UserDataServices;
import com.Iot.Agriculture.Service.UserDeviceService;
import com.Iot.Agriculture.Service.UserPermissionServices;
import com.Iot.Agriculture.Service.UserValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
public class UserPermissionController {

    @Autowired
    UserPermissionDataRepository userPermissionRepository;
    @Autowired
    ResponseBuilder responseBuilder;
    @Autowired
    UserDeviceService deviceService;

    @Autowired
    UserPermissionServices userPermissionService;
    @Autowired
    UserValidationService userValidationService;
    @Autowired
    UserDeviceDataRepository userDeviceRepository;
    @Autowired
    EmailService emailService;


    @PostMapping("/adddevice/{userId}")
    public UserDeviceDetailsDTO addDeviceToUser(@RequestBody UserDeviceDetailsDataModel deviceDetails) {
        //isuserpresent//isuserauthenticated//isusereligiblefordevice//isuserdevicelimit and active devices check
        if(userValidationService.UserValidationCheck_AddDevice(deviceDetails.getUserId())){
        UserPermissionDataModel permissionDetails = userPermissionService.getUserPermissionDetails(deviceDetails.getUserId());
        permissionDetails.setNoOfDevicesNotActive(permissionDetails.getNoOfDevicesNotActive() + 1);
        if (permissionDetails.getNoOfDevicesNotActive()+ permissionDetails.getNoOfDevicesActive()
                == permissionDetails.getDeviceLimit())
            permissionDetails.setEligibleForDevice(false);
        userPermissionRepository.save(permissionDetails);
        return responseBuilder.buildUserDeviceDetails(userDeviceRepository.save(deviceDetails));
        }
        else
            throw new RuntimeException("False value");
    }

    @GetMapping("/senddeviceactivationmail/{userId}")
    public void sendDeviceActivationMail(@PathVariable("userId") int userId) {
        UserDeviceDetailsDataModel deviceDetails = deviceService.getUserDeviceDetails(userId);
        emailService.sendDeviceActivationMail(userId, deviceDetails.getDeviceId());
    }

    @GetMapping("/activatedevice/{userid}/{deviceid}")
    public UserDeviceDetailsDTO activateDevice(@PathVariable("userid") int userId, @PathVariable("deviceid") int deviceId) {
        UserDeviceDetailsDataModel deviceDetails = deviceService.getUserDeviceDetails(userId);

        if(deviceDetails.isDeviceActive()){
            throw new RuntimeException("Device already activated");
        }

        UserPermissionDataModel permissionDetails = userPermissionService.getUserPermissionDetails(deviceDetails.getUserId());
        permissionDetails.setNoOfDevicesActive(permissionDetails.getNoOfDevicesActive()+1);
        permissionDetails.setNoOfDevicesNotActive(permissionDetails.getNoOfDevicesNotActive()-1);
        userPermissionRepository.save(permissionDetails);
        deviceDetails.setDeviceActive(true);
        return responseBuilder.buildUserDeviceDetails(userDeviceRepository.save(deviceDetails));
    }

    //add device deactivation
}