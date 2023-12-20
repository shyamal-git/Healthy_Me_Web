package com.healthyme.practo.service;

import com.healthyme.practo.entity.Review;

import java.util.List;

public interface ReviewService {

    public Review createReview(Review review);
    public List<Review> getReviewByDoctorId(long doctorId);
}
