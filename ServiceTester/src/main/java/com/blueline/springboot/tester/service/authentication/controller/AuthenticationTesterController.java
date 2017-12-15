package com.blueline.springboot.tester.service.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AuthenticationTesterController {
    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/test")
    public String authentication(){
        return restTemplate.getForEntity("http://AUTHENTICATION/hello",String.class).getBody();
    }
}
