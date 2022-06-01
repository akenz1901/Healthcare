package com.healthcare.doctor_onboarding.data.repository;

import com.healthcare.doctor_onboarding.data.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
