package com.example.BE_employees_performance.services;

import com.example.BE_employees_performance.dto.request.AssessmentCreateRequest;
import com.example.BE_employees_performance.dto.request.AssessmentUpdateRequest;
import com.example.BE_employees_performance.dto.response.AssessmentPageParameters;
import com.example.BE_employees_performance.dto.response.AssessmentReponse;
import com.example.BE_employees_performance.repository.AssessmentRepository;
import jakarta.servlet.http.HttpServletRequest;
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

    public List<AssessmentReponse> getAllAssessmentByEmployee(Integer employeeId, Integer page, Integer size){
        return assessmentRepository.getAllAssessmentByEmployee(employeeId,page,size);
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


    public Object updateAssessment(Integer employeeId, Integer assessmentId, AssessmentUpdateRequest body){
        log.info(assessmentId.toString());
        return assessmentRepository.updateAssessment(employeeId, assessmentId,body.getKpiId(),body.getKpaId(),body.getEvaluate(),body.getComments(),body.getLink());
    }


    public AssessmentReponse getAssessmentById(Integer assessmentId){
        return assessmentRepository.getAssessmentById(assessmentId);
    }


    public AssessmentCreateRequest createAssessment(Integer token, AssessmentCreateRequest body){
        return assessmentRepository.createAssessment(token,
                body.getEmployeeId(),
                body.getLineManagerId(),
                body.getKpiId(),
                body.getKpaId(),
                body.getEvaluate(),
                body.getComments(),
                body.getLink(),
                body.getCreatedAt(),
                body.getUpdatedAt());
    }

    public Integer deleteAssessmentById(Integer assessmentId){
        return assessmentRepository.deleteAssessmentById(assessmentId);
    }

    public List<AssessmentReponse> searchByName(String keyword){
        return assessmentRepository.searchByName(keyword);
    }
}
