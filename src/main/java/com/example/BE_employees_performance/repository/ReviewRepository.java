package com.example.BE_employees_performance.repository;

import com.example.BE_employees_performance.dto.response.EmployeeResponse;
import com.example.BE_employees_performance.dto.response.ReviewReponse;
import com.example.BE_employees_performance.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    @Query(value = "call get_all_reviews(:pages,:size)", nativeQuery = true)
    public List<ReviewReponse> getAllReviews(@Param("pages") Integer page, @Param("size") Integer size);

    @Query(value = "select count(employee_id) from reviews", nativeQuery = true)
    public Integer getTotalElements();
}
