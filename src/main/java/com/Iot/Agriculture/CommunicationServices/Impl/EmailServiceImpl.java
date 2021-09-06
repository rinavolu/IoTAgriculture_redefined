package com.Iot.Agriculture.CommunicationServices.Impl;

import com.Iot.Agriculture.CommunicationServices.EmailSenderService;
import com.Iot.Agriculture.CommunicationServices.EmailService;
import com.Iot.Agriculture.Handlers.Exception.InValidDeviceException;
import com.Iot.Agriculture.Model.UserRegistrationDataModel;
import com.Iot.Agriculture.Service.UserDataServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    EmailSenderService emailSenderService;
    @Autowired
    UserDataServices userDataService;


    @Override
    public void sendUserAuthentication(UserRegistrationDataModel userDetails) {
        String authenticationAPI="http://localhost:8080/validateuser/";

        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setTo(userDetails.getEmail());
        mailMessage.setSubject("Authentication Mail");
        authenticationAPI+=userDetails.getUserId()+"/"+userDetails.getValidationId();
        mailMessage.setText(authenticationAPI);
        emailSenderService.sendEmail(mailMessage);
        System.out.println("Authentication mail has been sent");
    }

    @Override
    public void sendDeviceActivationMail(int userId, int deviceId) {
        String deviceActivationAPI="http://localhost:8080/activatedevice/";
        UserRegistrationDataModel userDetails=userDataService.getUserDetails(userId);
        if(!userDetails.isUserValidated()){
            sendUserAuthentication(userDetails);
        }
        else {
            SimpleMailMessage mailMessage=new SimpleMailMessage();
            mailMessage.setTo(userDetails.getEmail());
            mailMessage.setSubject("Device activation mail");
            deviceActivationAPI+=userDetails.getUserId()+"/"+deviceId;
            mailMessage.setText(deviceActivationAPI);
            emailSenderService.sendEmail(mailMessage);
            System.out.println("Device activation mail has been sent");
        }
    }
}
