package com.teste.vehicleControl.services;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.teste.vehicleControl.dto.UserDetails;
import com.teste.vehicleControl.dto.UserParamDto;
import com.teste.vehicleControl.dto.VehicleData;
import com.teste.vehicleControl.exception.UserAlreadyExistsException;
import com.teste.vehicleControl.exception.UserNotFoundException;
import com.teste.vehicleControl.models.User;
import com.teste.vehicleControl.models.Vehicle;
import com.teste.vehicleControl.repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    @Autowired
    private VehicleService vehicleService;

    public void store(@Valid UserParamDto userRequest) {        
        validateUser(userRequest.getCpf(), userRequest.getEmail());
        User user = fromParamDtoToEntity(userRequest);
        repository.save(user);
    }

    private void validateUser(String cpf, String email) {
        Optional<User> userEmail = findByEmail(email);
        if(userEmail.isPresent()){            
            throw new UserAlreadyExistsException("Already exists a user with this email");
        }
        
        Optional<User> userCpf = findByCpf(cpf);                
        if(userCpf.isPresent()){            
            throw new UserAlreadyExistsException("Already exists a user with this cpf");
        }
    }

    public Optional<User> findByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }

    private Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    private User fromParamDtoToEntity(@Valid UserParamDto userRequest) {
        return new ModelMapper().map(userRequest, User.class);
    }

    public UserDetails show(@Valid String cpfUser) {
        User user = findByCpf(cpfUser).orElseThrow(() -> new UserNotFoundException("user not found"));
        List<Vehicle> vehicles = vehicleService.findByUser(user);
        UserDetails response = createUserDetailResponse(user, vehicles);
        return response;
    }

    private UserDetails createUserDetailResponse(User user, List<Vehicle> vehicles) {
        UserDetails userDetails = new UserDetails();
        userDetails.setUser(fromEntityToParamDto(user));
        userDetails.setVehiclesDetails(vehiclesDetails(vehicles));
        return userDetails;
    }

    private List<VehicleData> vehiclesDetails(List<Vehicle> vehicles) {
        List<VehicleData> vehiclesData = vehicleService.fromEntityToParamDto(vehicles);        
        for (VehicleData vehicle : vehiclesData) {
            vehicle.setRotationDay(calculateRotationDay(vehicle.getYear()));
            vehicle.setRotationActive(vehicle.getRotationDay().equals(LocalDate.now().getDayOfWeek()) ? true : false);            
        }
        return vehiclesData;
    }

    private DayOfWeek calculateRotationDay(String year) {
        int lastNumber = Integer.parseInt(year.split(" ")[0].substring(year.split(" ")[0].length() - 1));
        if (lastNumber == 0 || lastNumber == 1){
            return DayOfWeek.MONDAY;
        } else if (lastNumber == 2 || lastNumber == 3){
            return DayOfWeek.TUESDAY;
        } else if (lastNumber == 4 || lastNumber == 5){
            return DayOfWeek.WEDNESDAY;
        } else if (lastNumber == 6 || lastNumber == 7){
            return DayOfWeek.THURSDAY;
        }
        return DayOfWeek.FRIDAY;
    }

    private UserParamDto fromEntityToParamDto(User user) {        
        return new ModelMapper().map(user, UserParamDto.class);
    }    
    
}
