package com.example.BE_employees_performance.controllers;

import com.example.BE_employees_performance.dto.response.ApiResponse;
import com.example.BE_employees_performance.dto.response.AssessmentPageParameters;
import com.example.BE_employees_performance.dto.response.AssessmentReponse;
import com.example.BE_employees_performance.dto.response.EmployeeResponse;
import com.example.BE_employees_performance.services.EmployeeServices;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeControllers {
    EmployeeServices employeeServices;

    @GetMapping("/getAllEmployees")
    public ApiResponse<List<EmployeeResponse>> getAllEmployees(@RequestParam(defaultValue = "0") Integer page,
                                                         @RequestParam(defaultValue = "10") Integer size)
    {
        ApiResponse<List<EmployeeResponse>> apiResponse =  new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Get all employees successfully");
        apiResponse.setData(employeeServices.getAllEmployees(page,size));
        return apiResponse;
    }


    @GetMapping("/getEmployeeById/{accountId}")
    public ApiResponse<EmployeeResponse> getEmployeeById(@PathVariable Integer accountId)
    {
        ApiResponse<EmployeeResponse> apiResponse =  new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Get all employees successfully");
        apiResponse.setData(employeeServices.getEmployeeById(accountId));
        return apiResponse;
    }


    @GetMapping("/getTotalElements")
    public ApiResponse<Integer> getTotalElements(@RequestParam(defaultValue = "0") Integer page,
                                                                  @RequestParam(defaultValue = "10") Integer size){
        ApiResponse<Integer> apiResponse =  new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Get totals elements successfully");
        apiResponse.setData(employeeServices.getTotalElements());
        return apiResponse;
    }
}
