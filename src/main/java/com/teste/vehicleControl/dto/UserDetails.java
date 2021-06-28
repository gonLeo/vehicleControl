package com.teste.vehicleControl.dto;

import java.util.List;

public class UserDetails {
    private UserParamDto user;
    private List<VehicleData> vehiclesDetails;
    
    
    public UserParamDto getUser() {
        return user;
    }
    public void setUser(UserParamDto user) {
        this.user = user;
    }
    public List<VehicleData> getVehiclesDetails() {
        return vehiclesDetails;
    }
    public void setVehiclesDetails(List<VehicleData> vehiclesDetails) {
        this.vehiclesDetails = vehiclesDetails;
    }

    
}
