package com.teste.vehicleControl.dto;

import javax.validation.constraints.NotNull;

public class VehicleParamDto {
    @NotNull
    private String brand;

    @NotNull
    private String model;

    @NotNull
    private int year;

    @NotNull
    private Long userId;

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    
}
