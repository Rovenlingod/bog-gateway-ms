package com.example.boggatewayms.feign;

import com.example.boggatewayms.feign.feignDtos.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface UserServiceFeign {

    @GetMapping("/api/user/{login}")
    UserDTO getUserByLogin(@PathVariable(name = "login") String login);
}
