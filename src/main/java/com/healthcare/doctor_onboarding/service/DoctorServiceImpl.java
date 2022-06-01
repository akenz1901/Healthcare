package com.healthcare.doctor_onboarding.service;


import com.healthcare.doctor_onboarding.data.model.Address;
import com.healthcare.doctor_onboarding.data.model.Doctor;
import com.healthcare.doctor_onboarding.data.model.dto.AddressDto;
import com.healthcare.doctor_onboarding.data.repository.AddressRepository;
import com.healthcare.doctor_onboarding.data.repository.DoctorRepository;
import com.healthcare.doctor_onboarding.service.Exception.DoctorException;
import com.healthcare.doctor_onboarding.service.mapping.AddressDtoMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    AddressDtoMapping addressDtoMapping;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public Doctor registerDoctor(Doctor doctor) {
        if(doctor != null){
            return doctorRepository.save(doctor);
        }
        else
            throw new NullPointerException("Doctor can't be null");
    }

    @Override
    public List<Doctor> findAllDoctor() {
        List<Doctor> allDoctor = doctorRepository.findAll();
        if(allDoctor.isEmpty())
            throw new DoctorException("No doctor exist in the repo");
        else
            return allDoctor;
    }

    @Override
    public Doctor findDoctorById(Long id) {

        return doctorRepository.findById(id).orElse(null);
    }

    @Override
    public Doctor updateDoctorAddress(Long id, AddressDto addressDto) {

        if(addressDto == null)
            throw new DoctorException("expected address information is empty");

        Optional<Doctor> existingDoctor = doctorRepository.findById(id);

        if(existingDoctor.isPresent()){
            Doctor givenDoctor = existingDoctor.get();
            Address newAddress = givenDoctor.getAddress();

            addressDtoMapping.mapDtoAddressToExistingDoctorAddress(addressDto, newAddress);
            addressRepository.save(newAddress);

            return givenDoctor;
        }
        else
            throw new DoctorException("Doctor with the id " + id + " does not exist");
    }

    @Override
    public void deleteDoctor(Long id) {
        Optional<Doctor> foundDoctor = doctorRepository.findById(id);

        if(foundDoctor.isPresent()){
            doctorRepository.deleteById(id);
        }
        else
            throw new DoctorException("Doctor doesn't exist");
    }
}
