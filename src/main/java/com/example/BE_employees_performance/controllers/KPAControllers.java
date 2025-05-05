package com.example.BE_employees_performance.controllers;

import com.example.BE_employees_performance.dto.response.ApiResponse;
import com.example.BE_employees_performance.dto.response.KPAEvaluateResponse;
import com.example.BE_employees_performance.dto.response.KPANameResponse;
import com.example.BE_employees_performance.dto.response.KPAResponse;
import com.example.BE_employees_performance.services.KPAServices;
import jakarta.servlet.http.HttpServletRequest;
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

    @GetMapping("/getAllKpa")
    public ApiResponse<List<KPAResponse>> getAllKpa(){
        ApiResponse<List<KPAResponse>> apiResponse= new ApiResponse<List<KPAResponse>>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Get all by KPI successfully");
        apiResponse.setData(kpaServices.getAllKpa());
        return apiResponse;
    }


    @GetMapping("/getAllByKpi/{kpiID}")
    public ApiResponse<List<KPANameResponse>> getAllByKpi(@PathVariable Integer kpiID){
        ApiResponse<List<KPANameResponse>> apiResponse= new ApiResponse<List<KPANameResponse>>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Get all by KPI successfully");
        apiResponse.setData(kpaServices.getAllByKpi(kpiID));
        return apiResponse;
    }


    @GetMapping("/getKPAByKpiYear/{kpiID}/{employeeId}")
    public ApiResponse<List<KPAEvaluateResponse>> getKPAByKpiYear(@PathVariable Integer kpiID,
                                                                  @PathVariable Integer employeeId){
        ApiResponse<List<KPAEvaluateResponse>> apiResponse= new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Get all by KPI successfully");
        apiResponse.setData(kpaServices.getKPAByKpiYear(kpiID,employeeId));
        return apiResponse;
    }


    @DeleteMapping("/deleteKpa/{kpaId}")
    public ApiResponse<Integer> deleteKpa(HttpServletRequest request,
                                          @PathVariable Integer kpaId){
        ApiResponse<Integer> apiResponse= new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Delete KPA successfully");
        log.info(Integer.valueOf(request.getHeader("token")).toString());
        apiResponse.setData(kpaServices.deleteKpa(kpaId, Integer.valueOf(request.getHeader("token"))));
        return apiResponse;
    }
}
