package com.example.BE_employees_performance.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeManagerResponse {
    private Integer employeeId;
    private String employeeName;
    private String employeeJobTitle;
    private String employeeAvatar;
    private Integer lineManagerId;
    private String lineManagerName;
    private String lineManagerJobTitle;
    private String lineManagerAvatar;
}
