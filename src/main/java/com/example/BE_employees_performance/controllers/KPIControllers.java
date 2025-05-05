package com.example.BE_employees_performance.controllers;

import com.example.BE_employees_performance.dto.request.AccountRequest;
import com.example.BE_employees_performance.dto.response.AccountResponse;
import com.example.BE_employees_performance.dto.response.ApiResponse;
import com.example.BE_employees_performance.dto.response.KPINameResponse;
import com.example.BE_employees_performance.dto.response.KPIResponse;
import com.example.BE_employees_performance.services.KPIServices;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
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

    @GetMapping("/getAllKpi")
    public ApiResponse<List<KPIResponse>> getAllKpi(){
        ApiResponse<List<KPIResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Get all kpi successfully");
        apiResponse.setData(kpiServices.getAllKpi());
        return apiResponse;
    }


    @GetMapping("/getAllName")
    public ApiResponse<List<KPINameResponse>> getAllName(){
        ApiResponse<List<KPINameResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Get all name successfully");
        apiResponse.setData(kpiServices.getAllName());
        return apiResponse;
    }


    @GetMapping("/getAllNameByYear")
    public ApiResponse<List<KPINameResponse>> getAllNameByYear(@RequestParam("year") Integer year){
        ApiResponse<List<KPINameResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Get all name by year successfully");
        apiResponse.setData(kpiServices.getAllNameByYear(year));
        return apiResponse;
    }


    @GetMapping("/getKpiByYear/{year}")
    public ApiResponse<List<KPIResponse>> getKpiByYear(@PathVariable Integer year){
        ApiResponse<List<KPIResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Get all kpi by year successfully");
        apiResponse.setData(kpiServices.getKpiByYear(year));
        return apiResponse;
    }


    @GetMapping("/getEvaluationByKpi/{kpiId}/{employeeId}")
    public ApiResponse<Float> getEvaluationByKpi(@PathVariable Integer kpiId,
                                             @PathVariable Integer employeeId){
        ApiResponse<Float> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Get evaluation by kpi successfully");
        apiResponse.setData(kpiServices.getEvaluationByKpi(kpiId, employeeId));
        return apiResponse;
    }


    @DeleteMapping("/deleteKpi/{kpiId}")
    public ApiResponse<Integer> deleteKpi(HttpServletRequest request,
                                          @PathVariable Integer kpiId){
        ApiResponse<Integer> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Delete KPI successfully");
        apiResponse.setData(kpiServices.deleteKpi(kpiId, Integer.valueOf(request.getHeader("token"))));
        return apiResponse;
    }

}
