package com.pluralsight.conferencedemo.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PropertySource("classpath:application.properties")
public class HomeController {

    //We can inject the app version that we created in application.properties into the controller.
    //this custom notation tells Spring Boot and Spring to look in the properties section of the app and find that and inject the value
    //into the private string app.version attribute.
    @Value("${app.version}")
    private String appVersion;

    @GetMapping
    @RequestMapping("/")
    public Map getStatus() {
        Map map = new HashMap<String, String>();
        map.put("app-version", appVersion);
        return map;
        //Since Jackson is our marshalerf for objects to JSON, it'll take the map and its key-value pairs and just print them
        //back out to the response as a JSON payload.
    }
}
