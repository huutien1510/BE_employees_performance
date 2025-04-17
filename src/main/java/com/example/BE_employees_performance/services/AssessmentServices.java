package com.example.BE_employees_performance.services;

import com.example.BE_employees_performance.dto.response.AssessmentPageParameters;
import com.example.BE_employees_performance.dto.response.AssessmentReponse;
import com.example.BE_employees_performance.repository.AssessmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class AssessmentServices {
    AssessmentRepository assessmentRepository;

    public List<AssessmentReponse> getAllAssessmentByEmployee(Integer employeeID, Integer page, Integer size){
        return assessmentRepository.getAllAssessmentByEmployee(employeeID,page,size);
    }


    public AssessmentPageParameters getAssessmentByEmployeePageParameters(Integer employeeId){
        return assessmentRepository.getAssessmentByEmployeePageParameters(employeeId);
    }


    public List<AssessmentReponse> getAllAssessment(Integer page, Integer size){
        return assessmentRepository.getAllAssessment(page, size);
    }


    public AssessmentPageParameters getAssessmentPageParameters(){
        return assessmentRepository.getAssessmentPageParameters();
    }
}
