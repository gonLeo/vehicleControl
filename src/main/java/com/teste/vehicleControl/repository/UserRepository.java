package com.teste.vehicleControl.repository;

import java.util.Optional;

import com.teste.vehicleControl.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findAllByCpf(String cpf);

    Optional<User> findAllByEmail(String email);
    
}
