package com.teste.vehicleControl.repository;

import com.teste.vehicleControl.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
