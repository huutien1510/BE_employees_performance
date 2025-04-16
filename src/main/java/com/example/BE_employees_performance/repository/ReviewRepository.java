package com.example.BE_employees_performance.repository;

import com.example.BE_employees_performance.dto.response.EmployeeResponse;
import com.example.BE_employees_performance.dto.response.ReviewPageParameters;
import com.example.BE_employees_performance.dto.response.ReviewReponse;
import com.example.BE_employees_performance.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    @Query(value = "call get_all_reviews(:pages,:size)", nativeQuery = true)
    public List<ReviewReponse> getAllReviews(@Param("pages") Integer page, @Param("size") Integer size);

    @Query(value = "call get_review_page_parameters", nativeQuery = true)
    public ReviewPageParameters getReviewPageParameters();

    @Query(value = "call evaluate_assessment(:account_id,:assessment_id,:evaluate,:comments)", nativeQuery = true)
    public Object evaluateAssessment(@Param("account_id") Integer accountId,
                                      @Param("assessment_id") Integer assessmentId,
                                      @Param("evaluate") Integer evaluate,
                                      @Param("comments") String comments);


}
