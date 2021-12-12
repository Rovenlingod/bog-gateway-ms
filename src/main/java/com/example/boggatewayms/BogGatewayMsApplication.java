package com.example.boggatewayms;

import com.example.boggatewayms.security.jwt.JwtProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableFeignClients
@EnableConfigurationProperties(JwtProperties.class)
public class BogGatewayMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BogGatewayMsApplication.class, args);
    }

}
