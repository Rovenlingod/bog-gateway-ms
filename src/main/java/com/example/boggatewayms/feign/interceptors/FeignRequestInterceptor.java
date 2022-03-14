package com.example.boggatewayms.feign.interceptors;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Objects;


//@Component
public class FeignRequestInterceptor implements RequestInterceptor {
    private static final String AUTHORIZATION_HEADER= "Authorization";
    private static final String TOKEN_TYPE = "Bearer";

    @Override
    public void apply(RequestTemplate requestTemplate) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //System.out.println(Objects.isNull(authentication));
    }
}
