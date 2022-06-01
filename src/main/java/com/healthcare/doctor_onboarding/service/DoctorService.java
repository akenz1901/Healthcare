package com.healthcare.doctor_onboarding.service;

import com.healthcare.doctor_onboarding.data.model.Doctor;
import com.healthcare.doctor_onboarding.data.model.dto.AddressDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DoctorService{

    Doctor registerDoctor(Doctor doctor);
    List<Doctor> findAllDoctor();
    Doctor findDoctorById(Long id);
    Doctor updateDoctorAddress(Long id, AddressDto addressDto);
    void deleteDoctor(Long l);
}
