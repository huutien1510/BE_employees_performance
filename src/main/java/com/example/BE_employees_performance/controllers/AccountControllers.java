package com.example.BE_employees_performance.controllers;

import com.example.BE_employees_performance.dto.request.AccountRequest;
import com.example.BE_employees_performance.dto.response.AccountResponse;
import com.example.BE_employees_performance.dto.response.ApiResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import com.example.BE_employees_performance.services.AccountServices;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountControllers {
    private AccountServices accountServices;

    @PostMapping("/sign")
    public ApiResponse<AccountResponse> loginAction(@RequestBody AccountRequest data){
        log.info("Login endpoint hit with data: {}", data);
        return ApiResponse.<AccountResponse>builder()
                .code(200)
                .message("Get all accounts successfully")
                .data(accountServices.loginAccount(data))
                .build();
    }

}
