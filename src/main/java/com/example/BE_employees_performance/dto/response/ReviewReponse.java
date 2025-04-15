package com.example.BE_employees_performance.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReviewReponse {
    private Integer reviewId;
    private Integer assessmentId;
    private Integer employeeId;
    private String employeeName;
    private String employeeJobTitle;
    private Integer lineManagerId;
    private String lineManagerName;
    private String lineManagerJobTitle;
    private Integer kpaId;
    private String kpaName;
    private Integer kpiId;
    private String kpiName;
    private Integer employeeEvaluate;
    private String employeeLink;
    private Integer evaluate;
    private String comments;
    private String status;
    private Date updatedAt;
}
