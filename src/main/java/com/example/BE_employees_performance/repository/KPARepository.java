package com.example.BE_employees_performance.repository;

import com.example.BE_employees_performance.dto.response.KPAEvaluateResponse;
import com.example.BE_employees_performance.dto.response.KPANameResponse;
import com.example.BE_employees_performance.dto.response.KPAResponse;
import com.example.BE_employees_performance.entity.Kpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface KPARepository extends JpaRepository<Kpa,Integer> {

    @Query(value = "select kpa_id,kpi_id,kpa_name,percent,description from kpa", nativeQuery = true)
    public List<KPAResponse> getAllKpa();

    @Query(value = "call get_all_kpa_name_by_kpi(:kpi_id)", nativeQuery = true)
    public List<KPANameResponse> getAllByKpi(@Param("kpi_id") Integer kpiID);

    @Query(value = "call get_all_kpa_by_kpi(:kpi_id,:employeeId)", nativeQuery = true)
    public List<KPAEvaluateResponse> getKPAByKpiYear(@Param("kpi_id") Integer kpiId,
                                                     @Param("employeeId") Integer employeeId);

    @Query(value = "call delete_kpa(:kpaId,:accountId)", nativeQuery = true)
    public Integer deleteKpa(@Param("kpaId") Integer kpaId,
                          @Param("accountId") Integer accountId);
}
