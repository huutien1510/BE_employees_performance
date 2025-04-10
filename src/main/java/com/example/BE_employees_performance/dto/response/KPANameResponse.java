package com.example.BE_employees_performance.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KPANameResponse {
    private Integer kpaId;
    private String kpaName;
}
