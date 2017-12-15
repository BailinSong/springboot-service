package com.blueline.springboot.service.authentication.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class HelloController {
    Logger logger= LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/hello")
    public String hello(){
        List<ServiceInstance> serviceList=client.getInstances("AUTHENTICATION");
//        serviceList.forEach(serice-> System.out.println(serice));
        logger.info(serviceList.toString());
        return  "Hello !";
    }
}
