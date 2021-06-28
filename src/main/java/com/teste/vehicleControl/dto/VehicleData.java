package com.teste.vehicleControl.dto;

import java.time.DayOfWeek;

public class VehicleData {
    private String brand;
    private String model;
    private String year;
    private String value;
    private DayOfWeek rotationDay;
    private boolean rotationActive;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean getRotationActive() {
        return rotationActive;
    }

    public void setRotationActive(boolean rotationActive) {
        this.rotationActive = rotationActive;
    }

    public DayOfWeek getRotationDay() {
        return rotationDay;
    }

    public void setRotationDay(DayOfWeek rotationDay) {
        this.rotationDay = rotationDay;
    }

}
