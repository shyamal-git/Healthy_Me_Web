package com.healthyme.practo.service.serviceimpl;

import com.healthyme.practo.entity.Doctor;
import com.healthyme.practo.entity.Patient;
import com.healthyme.practo.entity.Review;
import com.healthyme.practo.repository.DoctorRepository;
import com.healthyme.practo.repository.PatientRepository;
import com.healthyme.practo.repository.ReviewRepository;
import com.healthyme.practo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review createReview(Review review) {
        Doctor doctor = doctorRepository.findById(review.getDoctorId()).get();

        Patient patient = patientRepository.findById(review.getPatentId()).get();

        Review saveReview = null;
        if (doctor != null || patient != null) {
            saveReview = reviewRepository.save(review);
        }

        return saveReview;
    }

    public List<Review> getReviewByDoctorId(long doctorId){
        List<Review> review = reviewRepository.findByDoctorId(doctorId);

        return review;
    }
}
