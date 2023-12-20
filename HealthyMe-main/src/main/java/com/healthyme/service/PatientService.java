package com.healthyme.practo.service;

import com.healthyme.practo.entity.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getAllPatients();
    Patient createPatient(Patient patient);
}
