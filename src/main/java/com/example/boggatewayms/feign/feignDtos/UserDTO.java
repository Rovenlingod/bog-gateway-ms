package com.example.boggatewayms.feign.feignDtos;

import lombok.Data;

@Data
public class UserDTO {
    private String id;
    private String login;
    private String encryptedPassword;
    private String email;
    private String firstName;
    private String lastName;
}
