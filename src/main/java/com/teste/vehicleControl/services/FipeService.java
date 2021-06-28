package com.teste.vehicleControl.services;

import java.util.List;

import javax.validation.Valid;

import com.teste.vehicleControl.dto.VehicleParamDto;
import com.teste.vehicleControl.dto.fipeApi.CarDto;
import com.teste.vehicleControl.dto.fipeApi.ResponseApiDto;
import com.teste.vehicleControl.dto.fipeApi.ResponseYearDto;
import com.teste.vehicleControl.dto.fipeApi.ResponseModelDto;
import com.teste.vehicleControl.repository.FipeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FipeService {
    
    @Autowired
    private FipeRepository repository;    
    
    public FipeService(){

    }
    
    public FipeService(FipeRepository fipeRepository){
        this.repository = fipeRepository;

    }

    public String searchVehicleValue(@Valid VehicleParamDto request) {
        long brandCode = findBrandCode(request.getBrand());
        long modelCode = findModelCode(brandCode, request.getModel());
        String codeYear = findYearCode(brandCode, modelCode, request.getYear());
        CarDto car = repository.getCar(brandCode, modelCode, codeYear);
        return car.getValue();
    }        

    private long findBrandCode(String brand) {
        List<ResponseApiDto> brands = repository.getAllBrands();        
        return getCodeNumber(brands, brand);
    }

    private long findModelCode(long brandCode, String modelName) {
        ResponseModelDto models = repository.getAllModels(brandCode);
        return getCodeNumber(models.getApiDtos(), modelName);
    }

    private String findYearCode(long brandCode, long modelCode, String year) {
        List<ResponseYearDto> years = repository.getAllYear(brandCode, modelCode);
        return years.stream().filter(obj -> obj.getName().equals(year)).findFirst().get().getCodeNumber();
        
    }    

    private long getCodeNumber(List<ResponseApiDto> responseApi, String name) {
        ResponseApiDto response = responseApi.stream().filter(obj -> obj.getName().equals(name)).findFirst().get();
        return response.getCodeNumber();
    }
    
}
