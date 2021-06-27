package com.teste.vehicleControl.controllers;

import javax.validation.Valid;

import com.teste.vehicleControl.dto.UserParamDto;
import com.teste.vehicleControl.dto.commons.ResponseBase;
import com.teste.vehicleControl.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final String SUCCES_OPERATION = "SUCCES OPERATION";
    
    @Autowired
    private UserService service;

    @PostMapping()
    public ResponseEntity<ResponseBase<UserParamDto>> store(@Valid @RequestBody UserParamDto userRequest){
        service.store(userRequest);
        var response = new ResponseBase<UserParamDto>().setSuccess(true).setMessage(SUCCES_OPERATION).setStatus(HttpStatus.CREATED.value());
        return ResponseEntity.ok(response);
    }
}
