package com.teste.vehicleControl.services;

import java.util.List;
import java.util.stream.Collectors;

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
        if (notFound(brandCode)){
            return "";
        };
        long modelCode = findModelCode(brandCode, request.getModel());
        if (notFound(modelCode)){
            return "";
        };
        String codeYear = findYearCode(brandCode, modelCode, request.getYear());
        if (notFoundYear(codeYear)){
            return "";
        };
        CarDto car = repository.getCar(brandCode, modelCode, codeYear);
        return car.getValue();
    }        

    private boolean notFoundYear(String yearCode) {
        if(yearCode == ""){
            return true;
        }
        return false;
    }

    private boolean notFound(long code) {
        if(code == -1){
            return true;
        }
        return false;
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
        String regexName = ".*" + year.toLowerCase() + ".*";
        List<ResponseYearDto> years = repository.getAllYear(brandCode, modelCode);
        List<ResponseYearDto> response = years.stream().filter(obj -> obj.getName().toLowerCase().matches(regexName)).collect(Collectors.toList());
        String codeYear = !response.isEmpty() ? response.get(0).getCodeNumber() : "";
        return codeYear;
        
    }    

    private long getCodeNumber(List<ResponseApiDto> responseApi, String name) {
        String regexName = ".*" + name.toLowerCase() + ".*";
        List<ResponseApiDto> response = responseApi.stream().filter(obj -> obj.getName().toLowerCase().matches(regexName)).collect(Collectors.toList());

        long codeNumber = !response.isEmpty() ? response.get(0).getCodeNumber() : -1;
        return codeNumber;
    }
    
}
