package com.java.d2helper.presentation.handler;

import com.java.d2helper.domain.exception.GenericApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(GenericApiException.class)
    public ResponseEntity<Map<String, Object>> handleGenericApi(GenericApiException e) {
        int status = 400;
        Throwable cause = e.getCause();

        if (cause instanceof HttpClientErrorException clientEx) {
            status = clientEx.getStatusCode().value();
        }

        return ResponseEntity.status(status)
                .body(Map.of(
                        "timestamp", LocalDateTime.now(),
                        "status", status,
                        "error", "Erro em API externa",
                        "message", e.getMessage()
                ));
    }
}