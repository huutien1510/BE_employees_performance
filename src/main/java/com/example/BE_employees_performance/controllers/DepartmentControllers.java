package com.example.BE_employees_performance.controllers;

import com.example.BE_employees_performance.dto.response.ApiResponse;
import com.example.BE_employees_performance.dto.response.AssessmentReponse;
import com.example.BE_employees_performance.dto.response.DepartmentNameResponse;
import com.example.BE_employees_performance.services.DepartmentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DepartmentControllers {
    DepartmentService departmentService;

    @GetMapping("/getAllDepartmentName")
    public ApiResponse<List<DepartmentNameResponse>> getAllDepartmentName(){
        ApiResponse<List<DepartmentNameResponse>> apiResponse =  new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Get all assessment by employee successfully");
        apiResponse.setData(departmentService.getAllDepartmentName());
        return apiResponse;
    }
}
