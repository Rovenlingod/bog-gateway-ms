package com.example.boggatewayms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class BogGatewayMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BogGatewayMsApplication.class, args);
    }

}
