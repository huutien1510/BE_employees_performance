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
@Table(name = "kpa")
public class Kpa  {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer kpaId;

    private String kpaName;

    @Lob
    private String description;
    private Integer percent;

    @ManyToOne
    @JoinColumn(name = "kpi_id")
    private Kpi kpi;

    private Date createdAt;
    private Date updateAt;
}