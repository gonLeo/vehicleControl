package com.teste.vehicleControl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class VehicleControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleControlApplication.class, args);
	}

}
