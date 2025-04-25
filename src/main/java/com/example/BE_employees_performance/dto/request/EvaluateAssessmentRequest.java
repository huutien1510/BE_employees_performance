package com.example.BE_employees_performance.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluateAssessmentRequest {
    private Integer evaluate;
    private String comments;
    private Date updatedAt;
}
