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
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;

    @Column(unique = true, length = 50)
    private String username;

    @Column(length = 1000)
    private String pwd;

    @Column(length = 20)
    private String accRole;

    private Date createdAt;
    private Date updateAt;
}
