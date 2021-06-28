package com.teste.vehicleControl.repository;

import java.util.List;

import com.teste.vehicleControl.models.User;
import com.teste.vehicleControl.models.Vehicle;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,Long> {

    List<Vehicle> findByUser(User user);
    
}
