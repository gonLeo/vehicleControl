package com.teste.vehicleControl.repository;

import java.util.List;

import com.teste.vehicleControl.dto.fipeApi.CarDto;
import com.teste.vehicleControl.dto.fipeApi.ResponseApiDto;
import com.teste.vehicleControl.dto.fipeApi.ResponseYearDto;
import com.teste.vehicleControl.dto.fipeApi.ResponseModelDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "FipeRepository", url="https://parallelum.com.br/fipe/api/v1/carros")
public interface FipeRepository {
    @RequestMapping(method = RequestMethod.GET, value = "/marcas")
    List<ResponseApiDto> getAllBrands();

    @RequestMapping(method = RequestMethod.GET, value = "/marcas/{brandCode}/modelos")
    ResponseModelDto getAllModels(@PathVariable("brandCode") long brandCode);

    @RequestMapping(method = RequestMethod.GET, value = "/marcas/{brandCode}/modelos/{modelCode}/anos")
    List<ResponseYearDto> getAllYear(@PathVariable("brandCode") long brandCode, @PathVariable("modelCode") long modelCode);

    @RequestMapping(method = RequestMethod.GET, value = "/marcas/{brandCode}/modelos/{modelCode}/anos/{codeYear}")
    CarDto getCar(@PathVariable("brandCode") long brandCode, @PathVariable("modelCode") long modelCode, @PathVariable("codeYear") String codeYear);
}
