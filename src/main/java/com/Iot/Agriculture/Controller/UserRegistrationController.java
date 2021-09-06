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

    @Autowired
    EmailService emailService;

    @PostMapping("/registeruser")
    public UserRegistrationMainDTO registerUser(@RequestBody UserRegistrationDataModel userData){
        UserRegistrationDataModel userRegistrationDetails=userRegistration.save(userData);
        emailService.sendUserAuthentication(userRegistrationDetails);
        return responseBuilder.buildRegisteredUserResponse(userRegistrationDetails,
                userDataService.saveUserPermissionDetails(userRegistrationDetails));
    }

    @GetMapping("/validateuser/{userId}/{verificationId}")
    public UserDetailsDTO authenticateUser(@PathVariable("userId") int userId, @PathVariable("verificationId") String verificationId){
        if(userDataService.isUserAuthenticated(userId)){
            //user already authenticated
            //use validation expired..
            throw new UserNotAuthenticatedException();
        }
        else{
            UserRegistrationDataModel userDetails=userDataService.getUserDetails(userId);
            if(!(userDetails.getValidationId().equals(verificationId))){
                throw new InValidVerificationIdException();
            }
            else {
                userDetails.setUserValidated(true);
                userDetails.setValidationExpired(true);
            }
            return responseBuilder.buildUserDetailsOnly(userRegistration.save(userDetails));
        }
    }
}
