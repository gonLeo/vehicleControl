package com.teste.vehicleControl.dto.fipeApi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CarDto {
    @JsonProperty("Valor")
    private String value;
    @JsonProperty("Marca")
    private String brand;
    @JsonProperty("AnoModelo")
    private long yearModel;
    @JsonProperty("Combustivel")
    private String fuel;
    @JsonProperty("CodigoFipe")
    private String codeFipe;
    @JsonProperty("MesReferencia")
    private String month;
    @JsonProperty("TipoVeiculo")
    private int vehicleType;
    @JsonProperty("SiglaCombustivel")
    private String initialFuel;
    
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public long getYearModel() {
        return yearModel;
    }
    public void setYearModel(long yearModel) {
        this.yearModel = yearModel;
    }
    public String getFuel() {
        return fuel;
    }
    public void setFuel(String fuel) {
        this.fuel = fuel;
    }
    public String getCodeFipe() {
        return codeFipe;
    }
    public void setCodeFipe(String codeFipe) {
        this.codeFipe = codeFipe;
    }
    public String getMonth() {
        return month;
    }
    public void setMonth(String month) {
        this.month = month;
    }
    public int getVehicleType() {
        return vehicleType;
    }
    public void setVehicleType(int vehicleType) {
        this.vehicleType = vehicleType;
    }
    public String getInitialFuel() {
        return initialFuel;
    }
    public void setInitialFuel(String initialFuel) {
        this.initialFuel = initialFuel;
    }
    
}
