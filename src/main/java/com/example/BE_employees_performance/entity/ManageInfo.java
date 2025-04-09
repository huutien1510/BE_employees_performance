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
@Table(name = "manage_info")
public class ManageInfo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer manageInfoId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employees employee;

    @ManyToOne
    @JoinColumn(name = "line_manager_id")
    private Employees lineManager;

    private java.sql.Date startDate;
    private java.sql.Date endDate;
}
