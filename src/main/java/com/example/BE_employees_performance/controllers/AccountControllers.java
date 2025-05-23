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
    AccountServices accountServices;

    @PostMapping("/login")
    public ApiResponse<AccountResponse> loginAction(@RequestBody AccountRequest data){
        log.info("Login result: {}", accountServices.loginAccount(data) == null);
        return ApiResponse.<AccountResponse>builder()
                .status(200)
                .message("Login successfully")
                .data(accountServices.loginAccount(data))
                .build();
    }

}
