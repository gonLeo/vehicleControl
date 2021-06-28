package com.teste.vehicleControl.controllers;

import javax.validation.Valid;

import com.teste.vehicleControl.dto.VehicleParamDto;
import com.teste.vehicleControl.dto.commons.ResponseBase;
import com.teste.vehicleControl.services.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    
    private static final String SUCCES_OPERATION = "SUCCES OPERATION";

    @Autowired
    private VehicleService service;

    @PostMapping()
    public ResponseEntity<ResponseBase<VehicleParamDto>> store(@Valid @RequestBody VehicleParamDto vehicleRequest){
        service.store(vehicleRequest);
        var response = new ResponseBase<VehicleParamDto>().setSuccess(true).setMessage(SUCCES_OPERATION).setStatus(HttpStatus.CREATED.value());
        return ResponseEntity.ok(response);
    }
}
