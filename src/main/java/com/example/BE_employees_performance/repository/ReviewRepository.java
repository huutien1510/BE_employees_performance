package com.example.BE_employees_performance.repository;

import com.example.BE_employees_performance.dto.response.ReviewPageParameters;
import com.example.BE_employees_performance.dto.response.ReviewReponse;
import com.example.BE_employees_performance.dto.response.ReviewResult;
import com.example.BE_employees_performance.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    @Query(value = "call get_all_reviews(:pages,:size)", nativeQuery = true)
    public List<ReviewReponse> getAllReviews(@Param("pages") Integer page, @Param("size") Integer size);

    @Query(value = "call get_all_reviews_by_line_manager(:accountId,:pages,:size)", nativeQuery = true)
    public List<ReviewReponse> getAllReviewsByLineManager(@Param("accountId") Integer accountId,@Param("pages") Integer page, @Param("size") Integer size);


    @Query(value = "call get_all_reviews_by_employee(:accountId,:pages,:size)", nativeQuery = true)
    public List<ReviewReponse> getAllReviewsByEmployee(@Param("accountId") Integer accountId,@Param("pages") Integer page, @Param("size") Integer size);

    @Query(value = "call get_review_page_parameters", nativeQuery = true)
    public ReviewPageParameters getReviewPageParameters();

    @Query(value = "call get_review_page_parameters_by_employee(:accountId)", nativeQuery = true)
    public ReviewPageParameters getReviewPageParametersByEmployee(@Param("accountId") Integer accountId);

    @Query(value = "call evaluate_assessment(:accountId,:assessment_id,:evaluate,:comments,:updatedAt)", nativeQuery = true)
    public Object evaluateAssessment(@Param("accountId") Integer accountId,
                                      @Param("assessment_id") Integer assessmentId,
                                      @Param("evaluate") Integer evaluate,
                                      @Param("comments") String comments,
                                      @Param("updatedAt") Date updatedAt);

    @Query(value = "call get_all_reviews_employee_by_year(:employeeId,:year)", nativeQuery = true)
    public Integer getOverallPerformanceByYear(@Param("employeeId") Integer employeeId,
                                               @Param("year") Integer year);

    @Query(value = "select evaluate, comments, updated_at from review where assessment_id = :assessmentId" , nativeQuery = true)
    public ReviewResult getReviewResultById(@Param("assessmentId") Integer assessmentId);

//    @Query(value = "call get_all_reviews_by_name(:keyword)", nativeQuery = true)
//    public List<ReviewReponse> searchByName(@Param("keyword") String keyword);

}
