package com.teste.vehicleControl.services;
import java.util.Optional;

import javax.validation.Valid;

import com.teste.vehicleControl.dto.UserParamDto;
import com.teste.vehicleControl.exception.UserAlreadyExistsException;
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
        validateUser(userRequest.getCpf(), userRequest.getEmail());
        User user = fromParamDtoToEntity(userRequest);
        repository.save(user);
    }

    private void validateUser(String cpf, String email) {
        Optional<User> userEmail = findAllByEmail(email);
        if(userEmail.isPresent()){            
            throw new UserAlreadyExistsException("Already exists a user with this email");
        }
        
        Optional<User> userCpf = findAllByCpf(cpf);                
        if(userCpf.isPresent()){            
            throw new UserAlreadyExistsException("Already exists a user with this cpf");
        }
    }

    private Optional<User> findAllByCpf(String cpf) {
        return repository.findAllByCpf(cpf);
    }

    private Optional<User> findAllByEmail(String email) {
        return repository.findAllByEmail(email);
    }

    private User fromParamDtoToEntity(@Valid UserParamDto userRequest) {
        return new ModelMapper().map(userRequest, User.class);
    }    
    
}
