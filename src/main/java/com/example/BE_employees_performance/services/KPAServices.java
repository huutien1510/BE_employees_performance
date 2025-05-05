package com.example.BE_employees_performance.services;

import com.example.BE_employees_performance.dto.response.KPAEvaluateResponse;
import com.example.BE_employees_performance.dto.response.KPANameResponse;
import com.example.BE_employees_performance.dto.response.KPAResponse;
import com.example.BE_employees_performance.repository.KPARepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class KPAServices {
    KPARepository kpaRepository;

    public List<KPAResponse> getAllKpa(){
        return kpaRepository.getAllKpa();
    }

    public List<KPANameResponse> getAllByKpi(Integer kpiID){
        return kpaRepository.getAllByKpi(kpiID);
    }

    public List<KPAEvaluateResponse> getKPAByKpiYear(Integer kpiID, Integer employeeId){
        return kpaRepository.getKPAByKpiYear(kpiID, employeeId);
    }

    public Integer deleteKpa(Integer kpaId, Integer accountId){
        return kpaRepository.deleteKpa(kpaId, accountId);
    }
}
