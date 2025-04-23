package com.example.BE_employees_performance.controllers;

import com.example.BE_employees_performance.dto.request.AccountRequest;
import com.example.BE_employees_performance.dto.response.AccountResponse;
import com.example.BE_employees_performance.dto.response.ApiResponse;
import com.example.BE_employees_performance.dto.response.KPINameResponse;
import com.example.BE_employees_performance.dto.response.KPIResponse;
import com.example.BE_employees_performance.services.KPIServices;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import com.example.BE_employees_performance.services.AccountServices;

import java.util.List;

@RestController
@RequestMapping("/kpi")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class KPIControllers {
    KPIServices kpiServices;

    @GetMapping("/getAllName")
    public ApiResponse<List<KPINameResponse>> getAllName(){
        ApiResponse<List<KPINameResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Get all successfully");
        apiResponse.setData(kpiServices.getAllName());
        return apiResponse;
    }


    @GetMapping("/getKpiByYear/{year}")
    public ApiResponse<List<KPIResponse>> getKpiByYear(@PathVariable Integer year){
        ApiResponse<List<KPIResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Get all successfully");
        apiResponse.setData(kpiServices.getKpiByYear(year));
        return apiResponse;
    }

}
