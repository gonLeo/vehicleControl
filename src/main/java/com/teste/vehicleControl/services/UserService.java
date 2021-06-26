package com.teste.vehicleControl.services;

import java.util.Date;

import javax.validation.Valid;

import com.teste.vehicleControl.dto.UserParamDto;
import com.teste.vehicleControl.models.User;
import com.teste.vehicleControl.repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public void store(@Valid UserParamDto userRequest) {
        validateBirthDay(userRequest.getBirthDate());
        User user = fromParamDtoToEntity(userRequest);
        repository.save(user);
    }

    private User fromParamDtoToEntity(@Valid UserParamDto userRequest) {
        return new ModelMapper().map(userRequest, User.class);
    }

    private void validateBirthDay(Date birthDate) {
        if(birthDate.after(new Date()) ){
            throw new Error("The birth date must be before today");
        }
    }
    
}
