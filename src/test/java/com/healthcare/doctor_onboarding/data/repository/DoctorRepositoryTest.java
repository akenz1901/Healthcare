package com.healthcare.doctor_onboarding.data.repository;

import com.healthcare.doctor_onboarding.data.model.Doctor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
class DoctorRepositoryTest {

    @BeforeEach
    void setUp(){}

    @Autowired
    DoctorRepository doctorRepository;

    @Test
    void testDoctorRepositoryBySavingDoctorRegistration(){

        Doctor doctor = new Doctor();
        doctor.setFirstname("Adesubonmi");
        doctor.setLastname("Sarah");
        doctor.setPhone("08183563309");
        doctor.setEmail("sarah143@gmail.com");

        assertThat(doctor).isNotNull();
        log.info("Doctor before registration --> {}", doctor);
        doctorRepository.save(doctor);
        assertThat(doctor.getId()).isNotNull();
        assertThat(doctorRepository.findById(1L)).isNotNull();
        log.info("After saving Doctor --> {}", doctor);
    }
}