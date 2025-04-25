package com.example.BE_employees_performance.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentNameResponse {
    private Integer departmentId;
    private String departmentName;
}
