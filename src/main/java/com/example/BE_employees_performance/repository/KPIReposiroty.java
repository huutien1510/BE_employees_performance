package com.example.BE_employees_performance.repository;

import com.example.BE_employees_performance.dto.response.KPINameResponse;
import com.example.BE_employees_performance.dto.response.KPIResponse;
import com.example.BE_employees_performance.entity.Kpi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KPIReposiroty extends JpaRepository<Kpi,Integer> {
    @Query(value = "select kpi_id, kpi_name, type, percent, kpi_year, description from kpi order by kpi_year desc", nativeQuery = true)
    public List<KPIResponse> getAllKpi();

    @Query(value = "call get_all_kpi_name", nativeQuery = true)
    public List<KPINameResponse> getAllName();

    @Query(value = "call get_all_kpi_name_by_year(:year)", nativeQuery = true)
    public List<KPINameResponse> getAllNameByYear(@Param("year") Integer year);

    @Query(value = "select kpi_id, kpi_name, type, percent, kpi_year, description from kpi where kpi_year = :year", nativeQuery = true)
    public List<KPIResponse> getKpiByYear(@Param("year") Integer year);

    @Query(value = "call get_evaluation_by_kpi(:kpiId,:employeeId)", nativeQuery = true)
    public Float getEvaluationByKpi(@Param("kpiId") Integer kpiId,
                                      @Param("employeeId") Integer employeeId);

    @Query(value = "call delete_kpi(:kpiId,:accountId)", nativeQuery = true)
    public Integer deleteKpi(@Param("kpiId") Integer kpiId,
                             @Param("accountId") Integer accountId);
}
