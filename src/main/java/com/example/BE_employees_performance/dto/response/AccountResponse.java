package com.example.BE_employees_performance.dto.response;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountResponse {
    private Integer accountId;
    private Integer employeeId;
    private String username;
    private String pwd;
    private String accRole;
}
