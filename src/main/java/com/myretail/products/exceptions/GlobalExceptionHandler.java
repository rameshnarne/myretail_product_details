package com.myretail.products.exceptions;

import com.myretail.products.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ApiServiceException.class)
    public ResponseEntity handleApiException(ApiServiceException apiExp) {
        Error error = new Error(apiExp.getMessage(), apiExp.getReasonCode());
        return new ResponseEntity(error, apiExp.getResponseCode());
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity handleRuntimeException(RuntimeException exp) {
        Error error = new Error(exp.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.name());
        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
