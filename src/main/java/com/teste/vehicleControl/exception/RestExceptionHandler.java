package com.teste.vehicleControl.exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.teste.vehicleControl.dto.commons.ErrorDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<?> handleResourceAlredyExists(UserAlreadyExistsException exception,
            HttpServletRequest request) {

        ErrorDto errorDetail = new ErrorDto();
        errorDetail.setMessage(exception.getMessage());
        errorDetail.setTimestamp(new Date().getTime());
        errorDetail.setSatus(HttpStatus.BAD_REQUEST.value());
        errorDetail.setSuccess(false);

        return new ResponseEntity<>(errorDetail, null, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(UserNotFoundException exception,
            HttpServletRequest request) {

        ErrorDto errorDetail = new ErrorDto();
        errorDetail.setMessage(exception.getMessage());
        errorDetail.setTimestamp(new Date().getTime());
        errorDetail.setSatus(HttpStatus.BAD_REQUEST.value());
        errorDetail.setSuccess(false);

        return new ResponseEntity<>(errorDetail, null, HttpStatus.BAD_REQUEST);
    }
    
}
