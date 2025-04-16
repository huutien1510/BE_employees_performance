package com.example.BE_employees_performance.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluateAssessmentRequest {
    private Integer evaluate;
    private String comments;
}
