package com.openpms.server;

import com.alibaba.fastjson2.JSONSchemaValidException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ServerExceptionHandler {
    @ExceptionHandler(JSONSchemaValidException.class)
    public ResponseEntity<?> handleValidationExceptions(JSONSchemaValidException exception) {
        Map<String, String> errors = new HashMap<>();
        errors.put("message", exception.getMessage());
        return ResponseEntity.badRequest().body(errors);
    }
}
