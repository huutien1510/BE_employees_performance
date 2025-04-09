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
@Table(name = "assessment")
public class Assessment  {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer assessmentId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employees employee;

    @ManyToOne
    @JoinColumn(name = "kpa_id")
    private Kpa kpa;

    @ManyToOne
    @JoinColumn(name = "kpi_id")
    private Kpi kpi;

    private Integer evaluate;
    private String comments;
    private String link;
}