package com.myretail.products.exceptions;

import com.myretail.products.constants.ProductDetailsConstants;
import com.myretail.products.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.UnexpectedTypeException;
import java.util.List;
import java.util.Set;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * This method handles all the exceptions thrown by ApiServiceException.
     * These exceptions are thrown by application based on custom validations
     * @param apiExp
     * @return
     */
    @ExceptionHandler(value = ApiServiceException.class)
    public ResponseEntity handleApiException(ApiServiceException apiExp) {
        Error error = new Error(apiExp.getReasonCode(), apiExp.getMessage());
        return new ResponseEntity(error, apiExp.getResponseCode());
    }

    /**
     * This method handles the Constraint violation exceptions thrown by ConstraintViolationException class.
     * These exceptions are thrown from the custom implementation of Validators
     * @param exception
     * @return
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity handleConstraintViolation(ConstraintViolationException exception) {
        Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
        StringBuilder strBuilder = new StringBuilder();
        for (ConstraintViolation<?> violation : violations ) {
            strBuilder.append(violation.getMessage() + " ");
        }
        Error error = new Error(HttpStatus.BAD_REQUEST.name(), strBuilder.toString());
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * This method handles the Http Message Not Readable exceptions thrown by HttpMessageNotReadableException class.
     * These exceptions are thrown by the application if request body is missing
     * @param exception
     * @return
     */
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity handleMessageNotReadableException(HttpMessageNotReadableException exception) {
        Error error = new Error(HttpStatus.BAD_REQUEST.name(), ProductDetailsConstants.BODY_MISSING);
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * This method handles the Unexpected Body exceptions thrown by UnexpectedTypeException class.
     * These exceptions are thrown by the application if request body is not in the defined format
     * @param exception
     * @return
     */
    @ExceptionHandler(value = UnexpectedTypeException.class)
    public ResponseEntity handleUnexpectedBodyException(UnexpectedTypeException exception) {
        Error error = new Error(HttpStatus.BAD_REQUEST.name(), exception.getMessage());
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * This method handles the Method Argument Not Valid exceptions thrown by MethodArgumentNotValidException class.
     * These exceptions are thrown by the application if request fields are not align with the required criteria
     * @param exception
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        StringBuilder strBuilder = new StringBuilder();
        for(FieldError fieldError : fieldErrors) {
            strBuilder.append(fieldError.getDefaultMessage() + " ");
        }
        Error error = new Error(HttpStatus.BAD_REQUEST.name(), strBuilder.toString());
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * This method handles all the Runtime exceptions thrown by RuntimeException.
     * These exceptions are thrown by application during rutime exceptions
     * @param exception
     * @return
     */
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity handleRuntimeException(RuntimeException exception) {
        Error error = new Error(HttpStatus.INTERNAL_SERVER_ERROR.name(), exception.getMessage());
        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
