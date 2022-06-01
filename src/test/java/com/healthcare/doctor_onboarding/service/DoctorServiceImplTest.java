package com.healthcare.doctor_onboarding.service;

import com.healthcare.doctor_onboarding.data.model.Address;
import com.healthcare.doctor_onboarding.data.model.Doctor;
import com.healthcare.doctor_onboarding.data.model.dto.AddressDto;
import com.healthcare.doctor_onboarding.data.repository.DoctorRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
class DoctorServiceImplTest {

    @Autowired
    DoctorRepository repository;

    @Autowired
    DoctorService doctorService;

    Doctor doctor;
    Address address;

    @BeforeEach
    void setUp(){
    }

    @Test
    void doctorCanBeRegisteredUsingService(){
        doctor = new Doctor();
        doctor.setFirstname("Akenz");
        doctor.setLastname("Dukky");
        doctor.setPhone("+2348183563382");
        doctor.setEmail("akenz1901@gmail.com");

        address = new Address();
        address.setHomeAddress("30 shoyinde street");
        address.setLga("Yaba mainland");
        address.setState("Lagos");

        doctor.setAddress(address);
        assertThat(doctor).isNotNull();

        log.info("Before registering doctor-->{}", doctor);
        doctorService.registerDoctor(doctor);

        log.info("After registering doctor-->{}", doctor);
        assertThat(repository.findById(1L)).isNotNull();
    }

    @Test
    void allDoctorCanBeFetched(){
        assertThat(doctorService.findAllDoctor()).isNotEmpty();
        log.info("All available doctor -->{}", doctorService.findAllDoctor());
    }

    @Test
    void singleDoctorCanBeFetched(){
        Doctor fetchedDoctor = doctorService.findDoctorById(1L);
        assertThat(fetchedDoctor).isNotNull();
        log.info("After doctor got searched -->{}", fetchedDoctor);
    }

    @Test
    void doctorAddressCanBeUpdated(){
        //when
        Doctor existingDoctor = doctorService.findDoctorById(1L);
        assertThat(existingDoctor).isNotNull();

        AddressDto newAddress = new AddressDto();
        newAddress.setHomeAddress("51 fijabi street lagos");
        newAddress.setLga("Lagos island");
        newAddress.setState("Lagos");


        assertThat(newAddress).isNotNull();

        log.info("Before updating doctor's address -->{}", existingDoctor.getAddress());
        Doctor updatedDoctor = doctorService.updateDoctorAddress(existingDoctor.getId(), newAddress);

        assertThat(updatedDoctor.getAddress().getHomeAddress())
                .isEqualTo(newAddress.getHomeAddress());
        log.info("After updating doctor's address -->{}", updatedDoctor.getAddress());

    }

    @Test
    void doctorCanBeDeleted(){
        Doctor doctor = doctorService.findDoctorById(1L);
        doctorService.deleteDoctor(doctor.getId());

        assertThat(doctorService.findDoctorById(doctor.getId())).isNull();
    }


}