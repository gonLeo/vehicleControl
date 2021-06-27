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
    public ResponseEntity<?> handleResourceNotFoundException(UserAlreadyExistsException userAlredyExists,
            HttpServletRequest request) {

        ErrorDto errorDetail = new ErrorDto();
        errorDetail.setMessage(userAlredyExists.getMessage());
        errorDetail.setTimestamp(new Date().getTime());
        errorDetail.setSatus(HttpStatus.CONFLICT.value());
        errorDetail.setSuccess(false);

        return new ResponseEntity<>(errorDetail, null, HttpStatus.CONFLICT);
    }
    
}
