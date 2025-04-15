package com.example.BE_employees_performance.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "departments")
public class Departments {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer departmentId;

    @Column(length = 50)
    private String departmentName;

    @Lob
    private String description;

    @OneToOne
    @JoinColumn(name = "function_head_id")
    private Employees functionHead;

    private Date createdAt;
    private Date updatedAt;
}