package com.hbrooks.controlleradvice;

import com.hbrooks.searchtrainapi.ServiceDetailsErrorResponse;
import com.hbrooks.searchtrainapi.ServiceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TrainRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ServiceDetailsErrorResponse> handleException(ServiceNotFoundException exc){

        ServiceDetailsErrorResponse error = new ServiceDetailsErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ServiceDetailsErrorResponse> handleException(Exception exc){

        ServiceDetailsErrorResponse error = new ServiceDetailsErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}