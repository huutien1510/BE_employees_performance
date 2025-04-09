package com.example.BE_employees_performance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "review")
public class Review  {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewId;

    @ManyToOne
    @JoinColumn(name = "line_manager_id")
    private Employees lineManager;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employees employee;

    @ManyToOne
    @JoinColumn(name = "assessment_id")
    private Assessment assessment;

    @ManyToOne
    @JoinColumn(name = "kpi_id")
    private Kpi kpi;

    @ManyToOne
    @JoinColumn(name = "kpa_id")
    private Kpa kpa;

    private Integer employeeEvaluate;
    private String employeeLink;
    private Integer evaluate;
    private String comments;
    private Boolean isReviewed;
}
