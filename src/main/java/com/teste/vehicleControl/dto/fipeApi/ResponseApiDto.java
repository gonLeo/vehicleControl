package com.teste.vehicleControl.dto.fipeApi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseApiDto {
    
    @JsonProperty("nome")
    private String nome;    
    @JsonProperty("codigo")
    private long codigo;
    
    public String getName() {
        return nome;
    }
    public void setName(String name) {
        this.nome = name;
    }
    public long getCodeNumber() {
        return codigo;
    }
    public void setCodeNumber(long codeNumber) {
        this.codigo = codeNumber;
    }

    
}
