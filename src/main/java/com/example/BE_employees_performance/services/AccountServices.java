package com.example.BE_employees_performance.services;
import com.example.BE_employees_performance.dto.request.AccountRequest;
import com.example.BE_employees_performance.dto.response.AccountResponse;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.BE_employees_performance.repository.AccountRepository;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class AccountServices {
    private AccountRepository accountRepository;

    public AccountResponse loginAccount(AccountRequest data){
        return accountRepository.loginAccount(data.getUsername(), data.getPwd());
    }
}