package com.Iot.Agriculture.Controller;

import com.Iot.Agriculture.DTO.UserSensorDataDTO;
import com.Iot.Agriculture.DTO.WeatherDTO;
import com.Iot.Agriculture.ExternalServices.WeatherService;
import com.Iot.Agriculture.Handlers.Exception.UserNotFoundException;
import com.Iot.Agriculture.Handlers.Exception.UserPermissionException;
import com.Iot.Agriculture.Model.UserSensorDataModel;
import com.Iot.Agriculture.Repository.SensorDataRepository;
import com.Iot.Agriculture.ResponseBuilder.ResponseBuilder;
import com.Iot.Agriculture.Service.DataServices;
import com.Iot.Agriculture.Service.UserDataServices;
import com.Iot.Agriculture.Service.UserPermissionServices;
import com.Iot.Agriculture.Service.UserValidationService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* *****************************
*  By: Ravindranadh Inavolu
* *****************************
* */

@Controller
@RestController
public class UserSensorDataController {

    @Autowired
    private SensorDataRepository sensorDataRepository;
    @Autowired
    private ResponseBuilder responseBuilder;

    //Services
    @Autowired
    private UserValidationService validationService;
    @Autowired
    private WeatherService weatherService;
    @Autowired
    private DataServices dataServices;
    @Autowired
    private UserPermissionServices userPermissionService;



    @PostMapping("/save/sensordata")
    private UserSensorDataModel saveSensorData(@RequestBody UserSensorDataModel userSensorDataModel_object) throws JSONException {
        if(validationService.UserValidationCheck_SaveSensorData(userSensorDataModel_object)) {
            WeatherDTO weatherData = weatherService.LoadAndGetWeatherData();
            userSensorDataModel_object.setArea_temperature(weatherData.getTemperature());
            return sensorDataRepository.save(userSensorDataModel_object);
        }
        else
            throw new RuntimeException("False value");
    }

    @GetMapping("/getsensordatabyuser/{userId}")
    private List<UserSensorDataDTO> getSensorDataByUser(@PathVariable("userId") int userId){
        if(validationService.UserValidationCheck_GetSensorData(userId)) {
            List<UserSensorDataModel> userSensorData = dataServices.getSensorDataByUserId(userId);
            return responseBuilder.buildUserSensorData(userSensorData);
        }
        else
            throw new RuntimeException("False value");
    }

}
