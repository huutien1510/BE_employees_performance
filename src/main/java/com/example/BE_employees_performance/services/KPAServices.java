package com.example.BE_employees_performance.services;

import com.example.BE_employees_performance.dto.response.KPANameResponse;
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

    public List<KPANameResponse> getAllByKpi(Integer kpiID){
        return kpaRepository.getAllByKpi(kpiID);
    }

}
