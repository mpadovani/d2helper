package com.java.d2helper.domain.exception;

public class GenericApiException extends RuntimeException {

    public GenericApiException(String message, Throwable cause) {
        super(message, cause);
    }
}