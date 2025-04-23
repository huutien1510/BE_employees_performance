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
    @Query(value = "call get_all_kpi_name", nativeQuery = true)
    public List<KPINameResponse> getAllName();

    @Query(value = "select kpi_id, kpi_name, type, percent from kpi where kpi_year = :year", nativeQuery = true)
    public List<KPIResponse> getKpiByYear(@Param("year") Integer year);
}
