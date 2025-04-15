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
@Table(name = "kpi")
public class Kpi {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer kpiId;

    private String kpiName;
    private Integer kpiYear;
    private String type;
    private Integer percent;

    @Lob
    private String description;

    private Date createdAt;
    private Date updatedAt;
}
