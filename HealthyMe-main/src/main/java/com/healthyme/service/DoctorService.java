package com.healthyme.practo.service;

import com.healthyme.practo.entity.Doctor;

import java.util.List;

public interface DoctorService {
    Doctor addDoctor(Doctor doctor);
    List<Doctor> getAllDoctors();

    List<Doctor> searchDoctors(String keyword);
}
