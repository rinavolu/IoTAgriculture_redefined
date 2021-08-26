package com.Iot.Agriculture.Controller;

import com.Iot.Agriculture.DTO.UserSensorDataDTO;
import com.Iot.Agriculture.Model.UserSensorDataModel;
import com.Iot.Agriculture.Repository.SensorDataRepository;
import com.Iot.Agriculture.ResponseBuilder.ResponseBuilder;
import com.Iot.Agriculture.Service.DataServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class UserSensorDataController {

    @Autowired
    private SensorDataRepository sensorDataRepository;

    @Autowired
    private DataServices dataServices;

    @Autowired
    private ResponseBuilder responseBuilder;

    @PostMapping("/save/sensordata")
    private UserSensorDataModel saveSensorData(@RequestBody UserSensorDataModel userSensorDataModel_object){
        return sensorDataRepository.save(userSensorDataModel_object);
    }

    @GetMapping("/getsensordatabyuser/{userId}")
    private List<UserSensorDataDTO> getSensorDataByUser(@PathVariable("userId") int userId){
        List<UserSensorDataModel> userSensorData=dataServices.getSensorDataByUserId(userId);
        return responseBuilder.buildUserSensorData(userSensorData);
    }

}
