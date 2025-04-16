package com.example.BE_employees_performance.controllers;

import com.example.BE_employees_performance.dto.request.EvaluateAssessmentRequest;
import com.example.BE_employees_performance.dto.response.*;
import com.example.BE_employees_performance.entity.Review;
import com.example.BE_employees_performance.services.ReviewServices;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReviewControllers {
    ReviewServices reviewServices;

    @GetMapping("/getAllReviews")
    public ApiResponse<List<ReviewReponse>> getAllReviews(@RequestParam(defaultValue = "0") Integer page,
                                                                 @RequestParam(defaultValue = "10") Integer size){
        ApiResponse<List<ReviewReponse>> apiResponse =  new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Get all reviews successfully");
        apiResponse.setData(reviewServices.getAllReviews(page,size));
        return apiResponse;
    }


    @GetMapping("/getTotalElements")
    public ApiResponse<ReviewPageParameters> getTotalElements(@RequestParam(defaultValue = "0") Integer page,
                                                              @RequestParam(defaultValue = "10") Integer size){
        ApiResponse<ReviewPageParameters> apiResponse =  new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Get totals elements successfully");
        apiResponse.setData(reviewServices.getReviewPageParameters());
        return apiResponse;
    }


    @PatchMapping("/evaluateAssessment/{assessmentId}")
    public ApiResponse<Object> evaluateAssessment(HttpServletRequest link,
                                                  @PathVariable Integer assessmentId,
                                                  @RequestBody EvaluateAssessmentRequest body){
        ApiResponse<Object> apiResponse =  new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Update evaluate assessment successfully");
        apiResponse.setData(reviewServices.evaluateAssessment(Integer.valueOf(link.getHeader("token")),assessmentId, body));
        return apiResponse;
    }
}
