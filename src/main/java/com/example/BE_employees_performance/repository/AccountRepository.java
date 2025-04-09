package com.example.BE_employees_performance.repository;

import com.example.BE_employees_performance.dto.response.AccountResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountRepository,Integer> {

    @Query("Call login(:username,:pwd)")
    public AccountResponse loginAccount(@Param("username") String username,
                                        @Param("pwd") String pwd);
}
