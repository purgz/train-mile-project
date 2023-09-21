package com.hbrooks.controlleradvice;

import com.hbrooks.searchtrainapi.ServiceDetailsErrorResponse;
import com.hbrooks.searchtrainapi.ServiceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;

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

    //handler to return 401 if user uses the react login
    @ExceptionHandler
    public ResponseEntity<BadCredentialsException> handleException(BadCredentialsException exception){

        return new ResponseEntity<>(exception, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler
    public ResponseEntity<AccessDeniedException> handleException(AccessDeniedException exc){

        return new ResponseEntity<>(exc, HttpStatus.FORBIDDEN);
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
