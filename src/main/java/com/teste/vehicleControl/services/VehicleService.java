package com.teste.vehicleControl.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.teste.vehicleControl.dto.VehicleData;
import com.teste.vehicleControl.dto.VehicleParamDto;
import com.teste.vehicleControl.exception.UserNotFoundException;
import com.teste.vehicleControl.models.User;
import com.teste.vehicleControl.models.Vehicle;
import com.teste.vehicleControl.repository.VehicleRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private FipeService fipeService;

    public void store(@Valid VehicleParamDto request) {
        User user = verifyUser(request.getUserCpf());
        String vehicleValue = fipeService.searchVehicleValue(request);
        Vehicle vehicle = createVehiclcle(request, user, vehicleValue);
        repository.save(vehicle);

    }

    private Vehicle createVehiclcle(@Valid VehicleParamDto request, User user, String vehicleValue) {
        Vehicle vehicle = fromParamDtoToEntity(request);
        vehicle.setUser(user);
        vehicle.setValue(vehicleValue);
        return vehicle;
    }

    private Vehicle fromParamDtoToEntity(@Valid VehicleParamDto request) {
        return new ModelMapper().map(request, Vehicle.class);
    }

    private User verifyUser(String userCpf) {
        User user = userService.findByCpf(userCpf).orElseThrow(() -> new UserNotFoundException("user not found"));
        return user;
    }

    public List<Vehicle> findByUser(User user) {
        return repository.findByUser(user);
    }

    public List<VehicleData> fromEntityToParamDto(List<Vehicle> vehicles) {
        return vehicles.stream().map(vehicle -> new ModelMapper().map(vehicle, VehicleData.class))
                .collect(Collectors.toList());
    }

}
