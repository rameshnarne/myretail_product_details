package com.myretail.products.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * This class helps to capture the exception details to display customized response to the clients
 */
@Setter
@Getter
@AllArgsConstructor
public class ApiServiceException extends RuntimeException {
    private String message;
    private String reasonCode;
    private HttpStatus responseCode;
}
