package com.teste.vehicleControl.dto.fipeApi;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseModelDto {
    @JsonProperty("modelos")
    List<ResponseApiDto> apiDtos;

    public List<ResponseApiDto> getApiDtos() {
        return apiDtos;
    }

    public void setApiDtos(List<ResponseApiDto> apiDtos) {
        this.apiDtos = apiDtos;
    }

    
}
