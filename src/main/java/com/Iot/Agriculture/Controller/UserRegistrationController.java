package com.Iot.Agriculture.Controller;

import com.Iot.Agriculture.DTO.UserRegistrationMainDTO;
import com.Iot.Agriculture.DTO.UserDetailsDTO;
import com.Iot.Agriculture.Model.UserRegistrationDataModel;
import com.Iot.Agriculture.Repository.UserRegistrationDataRepository;
import com.Iot.Agriculture.ResponseBuilder.ResponseBuilder;
import com.Iot.Agriculture.Service.UserDataServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
public class UserRegistrationController {

    @Autowired
    UserRegistrationDataRepository userRegistration;

    @Autowired
    UserDataServices userDataService;

    @Autowired
    ResponseBuilder responseBuilder;

    @PostMapping("/registeruser")
    public UserRegistrationMainDTO registerUser(@RequestBody UserRegistrationDataModel userData){
        UserRegistrationDataModel userRegistrationDetails=userRegistration.save(userData);
        return responseBuilder.buildRegisteredUserResponse(userRegistrationDetails,
                userDataService.saveUserPermissionDetails(userRegistrationDetails));
    }

    @GetMapping("/validateuser/{userId}/{verificationId}")
    public UserDetailsDTO authenticateUser(@PathVariable("userId") int userId, @PathVariable("verificationId") String verificationId){
        if(userDataService.isUserAuthenticated(userId)){
            //error handle
        }else{
            UserRegistrationDataModel userDetails=userDataService.getUserDetails(userId);
            if(!(userDetails.getValidationId().equals(verificationId))){
                //error handle
            }
            else {
                userDetails.setUserValidated(true);
                userDetails.setValidationExpired(true);
            }
            return responseBuilder.buildUserDetailsOnly(userRegistration.save(userDetails));
        }
        return null;
    }
}
