package com.example.BE_employees_performance.controllers;

import com.example.BE_employees_performance.dto.response.ApiResponse;
import com.example.BE_employees_performance.dto.response.AssessmentReponse;
import com.example.BE_employees_performance.services.AssessmentServices;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
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
        log.info(apiResponse.getData().toString());
        return apiResponse;
    }
}
