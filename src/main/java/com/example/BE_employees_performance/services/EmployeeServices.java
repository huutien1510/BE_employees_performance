package com.example.BE_employees_performance.services;

import com.example.BE_employees_performance.dto.response.EmployeeManagerResponse;
import com.example.BE_employees_performance.dto.response.EmployeeResponse;
import com.example.BE_employees_performance.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeServices {
    EmployeeRepository employeeRepository;

    public List<EmployeeResponse> getAllEmployees(Integer page, Integer size){
        return employeeRepository.getAllEmployees(page, size);
    }

    public EmployeeResponse getEmployeeById(Integer employeeId){
        return employeeRepository.getEmployeeById(employeeId);
    }

    public EmployeeManagerResponse getEmployeeManager(Integer employeeId){
        return  employeeRepository.getEmployeeManager(employeeId);
    }

    public Integer getTotalElements(){
        return employeeRepository.getTotalElements();
    }
}
