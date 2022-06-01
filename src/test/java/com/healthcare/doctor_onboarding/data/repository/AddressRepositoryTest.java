package com.healthcare.doctor_onboarding.data.repository;

import com.healthcare.doctor_onboarding.data.model.Address;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class AddressRepositoryTest {

    @Autowired
    AddressRepository addressRepository;

    @BeforeEach
    void setUp(){}

    @Test
    void addressCanBeCreatedAndBeSavedViaTheRepository(){

        Address address = new Address();
        address.setHomeAddress("61 Clinton street");
        address.setLga("Eti-Osa Local Goverment");
        address.setState("Lagos state");

        assertThat(address).isNotNull();
        log.info("Doctor before registration --> {}", address);
        addressRepository.save(address);

        assertThat(address.getId()).isNotNull();
        assertThat(addressRepository.findById(1L)).isNotNull();
        log.info("After saving Doctor --> {}", address);
    }

}