package com.example.BE_employees_performance.repository;

import com.example.BE_employees_performance.dto.response.AssessmentReponse;
import com.example.BE_employees_performance.entity.Assessment;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment,Integer> {
    @Query(value = "call get_all_assessment_by_employee(:employee_id)", nativeQuery = true)
    public List<AssessmentReponse> getAllAssessmentByEmployee(@Param("employee_id") Integer employeeID);

    @Query(value = "call get_all_assessment(:pages,:size)", nativeQuery = true)
    public List<AssessmentReponse> getAllAssessment(@Param("pages") Integer page, @Param("size") Integer size);

    @Query(value = "select count(assessment_id) from assessment;", nativeQuery = true)
    public Integer getTotalElements();
}
