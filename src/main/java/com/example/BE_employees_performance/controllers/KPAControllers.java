package com.example.BE_employees_performance.controllers;

import com.example.BE_employees_performance.dto.response.ApiResponse;
import com.example.BE_employees_performance.dto.response.KPANameResponse;
import com.example.BE_employees_performance.services.KPAServices;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kpa")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class KPAControllers {
    KPAServices kpaServices;

    @GetMapping("/getAllByKpi/{kpiID}")
    public ApiResponse<List<KPANameResponse>> getAllByKpi(@PathVariable Integer kpiID){
        ApiResponse<List<KPANameResponse>> apiResponse= new ApiResponse<List<KPANameResponse>>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Get all by KPI successfully");
        apiResponse.setData(kpaServices.getAllByKpi(kpiID));
        return apiResponse;
    }
}
