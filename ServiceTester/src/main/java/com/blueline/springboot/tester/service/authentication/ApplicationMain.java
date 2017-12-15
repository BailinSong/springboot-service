package com.blueline.springboot.tester.service.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class ApplicationMain {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }


    public static void main(String[] args) throws Exception {
        SpringApplication.main(args);
        ApplicationMain am=new ApplicationMain();
        System.out.println(am.restTemplate().getForEntity("http://AUTHENTICATION/hello",String.class).getBody());
    }
}
