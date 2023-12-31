package com.healthyme.practo.controller;

import com.healthyme.practo.entity.Doctor;
import com.healthyme.practo.entity.Review;
import com.healthyme.practo.payload.DoctorDto;
import com.healthyme.practo.repository.DoctorRepository;
import com.healthyme.practo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private DoctorRepository doctorRepository;


    @PostMapping
    private ResponseEntity<Review> createReview(@RequestBody Review review){
        return new ResponseEntity<>(reviewService.createReview(review), HttpStatus.CREATED);
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<DoctorDto> getReviewByDoctorId(@PathVariable long doctorId ){
        Doctor doctor = doctorRepository.findById(doctorId).get();
        List<Review> reviews = reviewService.getReviewByDoctorId(doctorId);
        int totalRatingPoints = 0;
        int totalReviews = 0;
        for (Review review : reviews) {
            totalRatingPoints += review.getRating();
            totalReviews++;
        }

        // Calculate the average rating as a percentage
        double averageRatingPercentage = (totalRatingPoints / (double)(totalReviews * 5)) * 100;


        DoctorDto dto=new DoctorDto();
        dto.setDoctor(doctor);
        dto.setReviews(reviews);
        dto.setRatingPercentage(averageRatingPercentage);

    return new ResponseEntity<>(dto,HttpStatus.OK);
    }



}
