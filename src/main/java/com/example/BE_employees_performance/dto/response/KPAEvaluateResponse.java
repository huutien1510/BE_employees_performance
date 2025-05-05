package com.example.BE_employees_performance.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KPAEvaluateResponse {
    private Integer kpaId;
    private String kpaName;
    private Float percent;
    private BigDecimal evaluate;
}
