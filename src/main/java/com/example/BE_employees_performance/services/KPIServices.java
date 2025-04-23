package com.example.BE_employees_performance.services;

import com.example.BE_employees_performance.dto.request.AccountRequest;
import com.example.BE_employees_performance.dto.response.AccountResponse;
import com.example.BE_employees_performance.dto.response.KPINameResponse;
import com.example.BE_employees_performance.dto.response.KPIResponse;
import com.example.BE_employees_performance.repository.KPIReposiroty;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.BE_employees_performance.repository.AccountRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class KPIServices {
    KPIReposiroty kpiReposiroty;

    public List<KPINameResponse> getAllName(){
        return  kpiReposiroty.getAllName();
    }

    public List<KPIResponse> getKpiByYear(Integer year){
        return kpiReposiroty.getKpiByYear(year);
    }
}
