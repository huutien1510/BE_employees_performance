package com.example.BE_employees_performance.controllers;

import com.example.BE_employees_performance.dto.response.ApiResponse;
import com.example.BE_employees_performance.dto.response.AssessmentPageParameters;
import com.example.BE_employees_performance.dto.response.AssessmentReponse;
import com.example.BE_employees_performance.services.AssessmentServices;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assessment")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AssessmentControllers {
    AssessmentServices assessmentServices;

    @GetMapping("/getAllAssessmentByEmployee/{employeeID}")
    public ApiResponse<List<AssessmentReponse>> getAllAssessmentByEmployee(@PathVariable Integer employeeID){
        ApiResponse<List<AssessmentReponse>> apiResponse =  new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Get all assessment by employee successfully");
        apiResponse.setData(assessmentServices.getAllAssessmentByEmployee(employeeID));
        return apiResponse;
    }


    @GetMapping("/getAllAssessment")
    public ApiResponse<List<AssessmentReponse>> getAllAssessment(@RequestParam(defaultValue = "0") Integer page,
                                                                 @RequestParam(defaultValue = "10") Integer size){
        ApiResponse<List<AssessmentReponse>> apiResponse =  new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Get all assessment successfully");
        apiResponse.setData(assessmentServices.getAllAssessment(page,size));
        return apiResponse;
    }



    @GetMapping("/getTotalElements")
    public ApiResponse<AssessmentPageParameters> getTotalElements(@RequestParam(defaultValue = "0") Integer page,
                                                                  @RequestParam(defaultValue = "10") Integer size){
        ApiResponse<AssessmentPageParameters> apiResponse =  new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Get totals elements successfully");
        apiResponse.setData(assessmentServices.getAssessmentPageParameters());
        return apiResponse;
    }



}
