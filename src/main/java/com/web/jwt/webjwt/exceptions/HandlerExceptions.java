package com.web.jwt.webjwt.exceptions;

import com.web.jwt.webjwt.model.exceptions.ProfileNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class HandlerExceptions extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProfileNotFoundException.class)
    public ResponseEntity<StanderError> profileNotFoundException(ProfileNotFoundException ex, HttpServletRequest request){
        StanderError err = new StanderError(ex.getMessage(), "NotFound",
                HttpStatus.NOT_FOUND, System.currentTimeMillis(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
