package com.example.boggatewayms.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 */
public class UnauthorisedException extends RuntimeException {

    public UnauthorisedException(String message) {
        super(message);
    }
}
