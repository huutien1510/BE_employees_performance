package com.example.BE_employees_performance.dto.request;

import com.example.BE_employees_performance.entity.Employees;
import com.example.BE_employees_performance.entity.Kpa;
import com.example.BE_employees_performance.entity.Kpi;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssessmentUpdateRequest {
    private Integer kpaId;
    private Integer kpiId;
    private Integer evaluate;
    private String comments;
    private String link;
}
