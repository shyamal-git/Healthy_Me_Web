package com.healthyme.practo.repository;

import com.healthyme.practo.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    // You can add custom query methods here if needed
}

