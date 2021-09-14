package com.Iot.Agriculture.DTO;

import org.json.JSONObject;

public class WeatherDTO {

     private int Temperature;
     private int pressure;
     private int humidity;
     private int feelsLike;
     private int uvIndex;

    public WeatherDTO() {
    }

    public WeatherDTO(int temperature, int pressure, int humidity, int feelsLike, int uvIndex) {
        Temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.feelsLike = feelsLike;
        this.uvIndex = uvIndex;
    }

    public int getTemperature() {
        return Temperature;
    }

    public void setTemperature(int temperature) {
        Temperature = temperature;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(int feelsLike) {
        this.feelsLike = feelsLike;
    }

    public int getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(int uvIndex) {
        this.uvIndex = uvIndex;
    }
}
