package com.example.service.service;

import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements IWeatherService{

    @Override
    public Integer getTemperature(String country, String city) {
        Double random=Math.floor(Math.random()*101);
        return random.intValue();
    }
}
