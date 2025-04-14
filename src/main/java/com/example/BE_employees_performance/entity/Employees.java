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
@Table(name = "employees")
public class Employees {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    private String name;
    private String email;
    private String phone;
    private String jobTitle;
    private java.sql.Date birthDate;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departments department;

    private Date createdAt;
    private Date updateAt;
}
