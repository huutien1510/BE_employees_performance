package com.example.BE_employees_performance.repository;

import com.example.BE_employees_performance.dto.response.DepartmentNameResponse;
import com.example.BE_employees_performance.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Departments,Integer> {

    @Query(value = "select department_id, department_name from departments", nativeQuery = true)
    public List<DepartmentNameResponse> getAllDepartmentName();
}
