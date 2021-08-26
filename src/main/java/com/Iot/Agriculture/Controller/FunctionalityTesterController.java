package com.Iot.Agriculture.Controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Controller
@RestController
public class FunctionalityTesterController {

    @GetMapping("/testweatherapi")
    public void testApi() throws  JSONException{
        String url ="http://api.weatherstack.com/current?access_key=3a96e4dfd592ce99a0f4de4b0ad33aca&query=Bhimavaram";
        RestTemplate restTemplate = new RestTemplate();
        String weatherData=restTemplate.getForObject(url,String.class);
        JSONObject json = new JSONObject(weatherData);
        JSONObject currentData=json.getJSONObject("current");
        System.out.println(currentData.get("temperature"));
    }

}
