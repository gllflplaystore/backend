package com.gllfl.user_service.exception;

public class JwtConfigurationException extends RuntimeException {

    public JwtConfigurationException(String message) {
        super(message);
    }

    public JwtConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
}