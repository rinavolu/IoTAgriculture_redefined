package com.Iot.Agriculture.Controller;

import com.Iot.Agriculture.CommunicationServices.EmailService;
import com.Iot.Agriculture.DTO.UserRegistrationMainDTO;
import com.Iot.Agriculture.DTO.UserDetailsDTO;
import com.Iot.Agriculture.Handlers.Exception.InValidVerificationIdException;
import com.Iot.Agriculture.Handlers.Exception.UserNotAuthenticatedException;
import com.Iot.Agriculture.Model.UserRegistrationDataModel;
import com.Iot.Agriculture.Repository.UserRegistrationDataRepository;
import com.Iot.Agriculture.ResponseBuilder.ResponseBuilder;
import com.Iot.Agriculture.Service.UserDataServices;
import com.Iot.Agriculture.Service.UserValidationService;
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
    UserValidationService userValidationService;
    @Autowired
    ResponseBuilder responseBuilder;
    @Autowired
    EmailService emailService;

    @PostMapping("/registeruser")
    public UserDetailsDTO registerUser(@RequestBody UserRegistrationDataModel userData){
        //email unique check
        UserRegistrationDataModel userRegistrationDetails=userRegistration.save(userData);
        emailService.sendUserAuthentication(userRegistrationDetails);
        return responseBuilder.buildUserDetailsOnly(userRegistrationDetails);
    }

    @GetMapping("/validateuser/{userId}/{verificationId}")
    public UserDetailsDTO authenticateUser(@PathVariable("userId") int userId, @PathVariable("verificationId") String verificationId){
        if(userValidationService.UserValidationCheck_Authentication(userId,verificationId)){
            UserRegistrationDataModel userDetails=userDataService.getUserDetails(userId);
            userDetails.setUserValidated(true);
            userDetails.setValidationExpired(true);
            //creates record in permission table
            userDataService.saveUserPermissions_Authenticated(userDetails);

            return responseBuilder.buildUserDetailsOnly(userRegistration.save(userDetails));
        }
        else
            throw new RuntimeException("False value");
    }
}
