package com.teste.vehicleControl.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class VehicleParamDto {
    @NotEmpty
    private String brand;

    @NotEmpty
    private String model;

    @NotNull
    private String year;

    @NotEmpty
    private String userCpf;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }    

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getUserCpf() {
        return userCpf;
    }

    public void setUserCpf(String userCpf) {
        this.userCpf = userCpf;
    }

    

    
}
