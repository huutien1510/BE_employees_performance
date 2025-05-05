package com.example.BE_employees_performance.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeesAdminResponse {
    private Integer employeeId;
    private String name;
    private String email;
    private String phone;
    private String jobTitle;
    private Date birthDate;
    private String avatar;
    private Long reviewed;
    private Long pending;
}
