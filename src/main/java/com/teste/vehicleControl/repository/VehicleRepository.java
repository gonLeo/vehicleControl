package com.teste.vehicleControl.repository;

import com.teste.vehicleControl.models.Vehicle;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
    
}
