package com.example.BE_employees_performance.controllers;

import com.example.BE_employees_performance.dto.response.*;
import com.example.BE_employees_performance.services.EmployeeServices;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeControllers {
    EmployeeServices employeeServices;

    @GetMapping("/getAllEmployees")
    public ApiResponse<List<EmployeeResponse>> getAllEmployees(@RequestParam(defaultValue = "0") Integer page,
                                                         @RequestParam(defaultValue = "10") Integer size)
    {
        ApiResponse<List<EmployeeResponse>> apiResponse =  new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Get all employees successfully");
        apiResponse.setData(employeeServices.getAllEmployees(page,size));
        return apiResponse;
    }


    @GetMapping("/getAllEmployeesAdmin")
    public ApiResponse<List<EmployeesAdminResponse>> getAllEmployeesAdmin(@RequestParam(defaultValue = "0") Integer page,
                                                               @RequestParam(defaultValue = "10") Integer size)
    {
        ApiResponse<List<EmployeesAdminResponse>> apiResponse =  new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Get all employees successfully");
        apiResponse.setData(employeeServices.getAllEmployeesAdmin(page,size));
        return apiResponse;
    }


    @GetMapping("/getAllEmployeesSideBar")
    public ApiResponse<List<EmployeeSidebarResponse>> getAllEmployeesSideBar()
    {
        ApiResponse<List<EmployeeSidebarResponse>> apiResponse =  new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Get all employees sidebar successfully");
        apiResponse.setData(employeeServices.getAllEmployeesSideBar());
        return apiResponse;
    }


    @GetMapping("/getAllManagerSideBar")
    public ApiResponse<List<EmployeeSidebarResponse>> getAllManagerSideBar()
    {
        ApiResponse<List<EmployeeSidebarResponse>> apiResponse =  new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Get all employees sidebar successfully");
        apiResponse.setData(employeeServices.getAllManagerSideBar());
        return apiResponse;
    }


    @GetMapping("/getEmployeeById/{employeeId}")
    public ApiResponse<EmployeeResponse> getEmployeeById(@PathVariable Integer employeeId)
    {
        ApiResponse<EmployeeResponse> apiResponse =  new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Get all employees successfully");
        apiResponse.setData(employeeServices.getEmployeeById(employeeId));
        return apiResponse;
    }


    @GetMapping("/getEmployeeManager/{employeeId}")
    public ApiResponse<EmployeeManagerResponse> getEmployeeManager(@PathVariable Integer employeeId)
    {
        ApiResponse<EmployeeManagerResponse> apiResponse =  new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Get employee manager successfully");
        apiResponse.setData(employeeServices.getEmployeeManager(employeeId));
        return apiResponse;
    }


    @GetMapping("/getTotalElements")
    public ApiResponse<Integer> getTotalElements(@RequestParam(defaultValue = "0") Integer page,
                                                                  @RequestParam(defaultValue = "10") Integer size){
        ApiResponse<Integer> apiResponse =  new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Get totals elements successfully");
        apiResponse.setData(employeeServices.getTotalElements());
        return apiResponse;
    }


    @GetMapping("/searchByName")
    public ApiResponse<List<EmployeeResponse>> searchByName(@RequestParam("keyword") String keyword){
        ApiResponse<List<EmployeeResponse>> apiResponse =  new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Get totals elements successfully");
        apiResponse.setData(employeeServices.searchByName(keyword));
        return apiResponse;
    }
}
