package com.example.BE_employees_performance.controllers;

import com.example.BE_employees_performance.dto.request.AssessmentCreateRequest;
import com.example.BE_employees_performance.dto.request.AssessmentUpdateRequest;
import com.example.BE_employees_performance.dto.response.ApiResponse;
import com.example.BE_employees_performance.dto.response.AssessmentPageParameters;
import com.example.BE_employees_performance.dto.response.AssessmentReponse;
import com.example.BE_employees_performance.dto.response.EmployeeResponse;
import com.example.BE_employees_performance.services.AssessmentServices;
import jakarta.servlet.http.HttpServletRequest;
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

    @GetMapping("/getAllAssessmentByEmployee/{employeeId}")
    public ApiResponse<List<AssessmentReponse>> getAllAssessmentByEmployee(@PathVariable Integer employeeId,
                                                                           @RequestParam(defaultValue = "0") Integer page,
                                                                           @RequestParam(defaultValue = "10") Integer size){
        ApiResponse<List<AssessmentReponse>> apiResponse =  new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Get all assessment by employee successfully");
        apiResponse.setData(assessmentServices.getAllAssessmentByEmployee(employeeId,page,size));
        return apiResponse;
    }


    @GetMapping("/getTotalElementsByEmployee/{employeeId}")
    public ApiResponse<AssessmentPageParameters> getAssessmentByEmployeePageParameters(@PathVariable Integer employeeId){
        ApiResponse<AssessmentPageParameters> apiResponse =  new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Get totals elements successfully");
        apiResponse.setData(assessmentServices.getAssessmentByEmployeePageParameters(employeeId));
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
    public ApiResponse<AssessmentPageParameters> getTotalElements(){
        ApiResponse<AssessmentPageParameters> apiResponse =  new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Get totals elements successfully");
        apiResponse.setData(assessmentServices.getAssessmentPageParameters());
        return apiResponse;
    }


    @GetMapping("/getAssessmentById/{assessmentId}")
    public ApiResponse<AssessmentReponse> getAssessmentById(@PathVariable Integer assessmentId){
        ApiResponse<AssessmentReponse> apiResponse =  new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Get assessment by ID successfully");
        apiResponse.setData(assessmentServices.getAssessmentById(assessmentId));
        return apiResponse;
    }


    @PatchMapping("/updateAssessment/{assessmentId}")
    public ApiResponse<Object> updateAssessment(HttpServletRequest request,
                                                @PathVariable Integer assessmentId,
                                                @RequestBody AssessmentUpdateRequest body){
        ApiResponse<Object> apiResponse =  new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Update assessment successfully");
        apiResponse.setData(assessmentServices.updateAssessment(Integer.valueOf(request.getHeader("token")),assessmentId,body));
        return apiResponse;
    }


    @PostMapping("/createAssessment")
    public ApiResponse<AssessmentCreateRequest> createAssessment(HttpServletRequest request,
                                                @RequestBody AssessmentCreateRequest body){
        ApiResponse<AssessmentCreateRequest> apiResponse =  new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Update assessment successfully");
        apiResponse.setData(assessmentServices.createAssessment(Integer.valueOf(request.getHeader("token")),body));
        return apiResponse;
    }


    @DeleteMapping("/deleteAssessmentById/{assessmentId}")
    public ApiResponse<Integer> deleteAssessmentById(@PathVariable Integer assessmentId){
        ApiResponse<Integer> apiResponse =  new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Delete assessment successfully");
        apiResponse.setData(assessmentServices.deleteAssessmentById(assessmentId));
        return apiResponse;
    }


    @GetMapping("/searchByName")
    public ApiResponse<List<AssessmentReponse>> searchByName(@RequestParam("keyword") String keyword){
        ApiResponse<List<AssessmentReponse>> apiResponse =  new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Get totals elements successfully");
        apiResponse.setData(assessmentServices.searchByName(keyword));
        return apiResponse;
    }


}
