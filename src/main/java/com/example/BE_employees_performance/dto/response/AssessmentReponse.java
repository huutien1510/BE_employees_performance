package com.example.BE_employees_performance.dto.response;

import com.example.BE_employees_performance.entity.Employees;
import com.example.BE_employees_performance.entity.Kpa;
import com.example.BE_employees_performance.entity.Kpi;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AssessmentReponse {
    private Integer assessmentId;
    private Integer employeeId;
    private String employeeName;
    private String employeeJobTitle;
    private Integer kpaId;
    private String kpaName;
    private Integer kpiId;
    private String kpiName;
    private Integer evaluate;
    private String comments;
    private String link;
    private boolean isReviewed;
}
