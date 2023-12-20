package com.healthyme.practo.repository;


import com.healthyme.practo.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<Review> findByDoctorId(Long Id);

}
