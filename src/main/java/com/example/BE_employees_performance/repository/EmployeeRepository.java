package com.example.BE_employees_performance.repository;

import com.example.BE_employees_performance.dto.response.AssessmentReponse;
import com.example.BE_employees_performance.dto.response.EmployeeResponse;
import com.example.BE_employees_performance.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees,Integer> {
    @Query(value = "call get_all_employees(:pages,:size)", nativeQuery = true)
    public List<EmployeeResponse> getAllEmployees(@Param("pages") Integer page, @Param("size") Integer size);

    @Query(value = "select count(employee_id) from employees", nativeQuery = true)
    public Integer getTotalElements();

}
