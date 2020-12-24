package com.adphilip.conf.conference.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Value("${app.version}")
    private String appVersion; 

    @GetMapping
    @RequestMapping("/")
    public Map <String, String> getStatus(){
        Map<String, String> myMap = new HashMap<>();
        myMap.put("app-version", appVersion);
        return myMap;
        
    }
    
}