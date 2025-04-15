package com.example.BE_employees_performance.dto.response;

import com.example.BE_employees_performance.entity.Account;
import com.example.BE_employees_performance.entity.Departments;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeResponse {
    private Integer employeeId;
    private String name;
    private String email;
    private String phone;
    private String jobTitle;
    private Date birthDate;
    private String avatar;
    private Integer lineManagerId;
    private String lineManagerName;
    private String lineManagerJobTitle;
    private Integer departmentId;
    private String departmentName;
}
