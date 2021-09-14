package com.Iot.Agriculture.ExternalServices;

import com.Iot.Agriculture.DTO.WeatherDTO;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Calendar;

@Service
public class WeatherServiceImpl implements WeatherService{

    private String weatherURL="http://api.weatherstack.com/current?access_key=3a96e4dfd592ce99a0f4de4b0ad33aca&query=Bhimavaram";
    private WeatherDTO prevWeatherData;

    @Override
    public WeatherDTO LoadAndGetWeatherData() throws JSONException {
        boolean flag=false;
        if(prevWeatherData==null) flag=true;
        Calendar date = Calendar.getInstance();
        int minutes = date.get(Calendar.MINUTE);
        if(flag||minutes == 0 || minutes == 30){
            //System.out.println("LOADING DATA");
            JSONObject weatherJsonData=new JSONObject(getWeatherData());
            WeatherDTO weatherDTO=getWeatherDTO(weatherJsonData);
            prevWeatherData=weatherDTO;
            return weatherDTO;
        }
        else {
            //System.out.println("USING PREV DATA");
            return prevWeatherData;
        }
    }

    public String getWeatherData(){
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject(weatherURL,String.class);
    }

    public WeatherDTO getWeatherDTO(JSONObject weatherData) throws JSONException{
        WeatherDTO weatherDTO=new WeatherDTO();
        JSONObject currentWeather=weatherData.getJSONObject("current");
        weatherDTO.setTemperature((Integer)currentWeather.get("temperature"));
        weatherDTO.setPressure((Integer) currentWeather.get("pressure"));
        weatherDTO.setHumidity((Integer) currentWeather.get("humidity"));
        weatherDTO.setFeelsLike((Integer) currentWeather.get("feelslike"));
        weatherDTO.setUvIndex((Integer) currentWeather.get("uv_index"));
        return  weatherDTO;
    }

}
