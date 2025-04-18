package com.example.BE_employees_performance.services;

import com.example.BE_employees_performance.dto.request.EvaluateAssessmentRequest;
import com.example.BE_employees_performance.dto.response.ReviewPageParameters;
import com.example.BE_employees_performance.dto.response.ReviewReponse;
import com.example.BE_employees_performance.entity.Review;
import com.example.BE_employees_performance.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class ReviewServices {
    ReviewRepository reviewRepository;

    public List<ReviewReponse> getAllReviews(Integer page, Integer size){
        return  reviewRepository.getAllReviews(page, size);
    }

    public List<ReviewReponse> getAllReviewsByEmployee(Integer accountId, Integer page, Integer size){
        return  reviewRepository.getAllReviewsByEmployee(accountId, page, size);
    }

    public ReviewPageParameters getReviewPageParameters(){
        return reviewRepository.getReviewPageParameters();
    }

    public ReviewPageParameters getReviewPageParametersByEmployee(Integer accountId) {
        return  reviewRepository.getReviewPageParametersByEmployee(accountId);
    }

    public Object evaluateAssessment(Integer accountId, Integer assessmentId, EvaluateAssessmentRequest body){
        return reviewRepository.evaluateAssessment(accountId, assessmentId, body.getEvaluate(), body.getComments());
    }
}
