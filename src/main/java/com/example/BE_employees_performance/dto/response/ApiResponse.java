package com.example.BE_employees_performance.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) // field khong xac dinh cu the se mac dinh la private
@JsonInclude(JsonInclude.Include.NON_NULL) // neu null thi ko kem vao json ->message
public class ApiResponse <T>{
    int status = 1000;
    String message;
    T data;
}