package com.teste.vehicleControl.dto.fipeApi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseYearDto {
    @JsonProperty("nome")
    private String nome;    
    @JsonProperty("codigo")
    private String codigo;
    
    public String getName() {
        return nome;
    }
    public void setName(String name) {
        this.nome = name;
    }
    public String getCodeNumber() {
        return codigo;
    }
    public void setCodeNumber(String codeNumber) {
        this.codigo = codeNumber;
    }
}
