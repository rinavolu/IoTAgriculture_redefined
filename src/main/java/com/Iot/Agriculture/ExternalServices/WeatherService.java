package com.Iot.Agriculture.ExternalServices;

import com.Iot.Agriculture.DTO.WeatherDTO;
import org.json.JSONException;
import org.json.JSONObject;

public interface WeatherService {

    WeatherDTO LoadAndGetWeatherData() throws JSONException;
}
