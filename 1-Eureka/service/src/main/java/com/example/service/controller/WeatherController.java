package com.example.service.controller;

import com.example.service.service.IWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletResponse;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final IWeatherService weatherService;

    @Autowired
    public WeatherController(IWeatherService weatherService) {
        this.weatherService=weatherService;
    }

    @GetMapping
    public ResponseEntity Temperature(@RequestParam String city, @RequestParam String country){
        return  ResponseEntity.ok(weatherService.getTemperature(city, country));
    }
}
