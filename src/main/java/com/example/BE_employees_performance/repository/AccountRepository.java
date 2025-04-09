package com.example.BE_employees_performance.repository;

import com.example.BE_employees_performance.dto.response.AccountResponse;
import com.example.BE_employees_performance.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {

    @Query(value = "Call login(:username,:pwd)", nativeQuery = true)
    public AccountResponse loginAccount(@Param("username") String username,
                                        @Param("pwd") String pwd);
}
