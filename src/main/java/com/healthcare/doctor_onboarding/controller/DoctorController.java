package com.healthcare.doctor_onboarding.controller;

import com.healthcare.doctor_onboarding.data.model.Address;
import com.healthcare.doctor_onboarding.data.model.Doctor;
import com.healthcare.doctor_onboarding.data.model.dto.AddressDto;
import com.healthcare.doctor_onboarding.service.DoctorService;
import com.healthcare.doctor_onboarding.service.Exception.DoctorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/register")
    public ResponseEntity<?> registerDoctor(@RequestBody Doctor doctor){
        return ResponseEntity.ok()
                .body(doctorService.registerDoctor(doctor));
    }

    @GetMapping("/all")
    public List<Doctor> getAllAvailableDoctors(){
        return doctorService.findAllDoctor();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSingleDoctor(@PathVariable Long id){

        Doctor foundDoctor;

        try{
            foundDoctor = doctorService.findDoctorById(id);
        }
        catch(NullPointerException doctorException){
            return ResponseEntity.badRequest().body("Doctor does not exist");
        }

        return ResponseEntity.ok().body(foundDoctor);
    }

    @PatchMapping("/{doctorId}/edit/address")
    public ResponseEntity<?> editDoctorAddress(@PathVariable Long doctorId, @RequestBody AddressDto address){

        Doctor modifiedDoctor;

        try{
            modifiedDoctor = doctorService.updateDoctorAddress(doctorId, address);
        }catch(DoctorException doctorException){
            doctorException.printStackTrace();
            return ResponseEntity.badRequest().body(doctorException.getMessage());
        }
        return ResponseEntity.ok().body(modifiedDoctor);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable Long id){
        try {
            doctorService.deleteDoctor(id);
        }catch(DoctorException doctorException){
            doctorException.printStackTrace();
            return ResponseEntity.badRequest().body(doctorException.getMessage());
        }
        return ResponseEntity.ok().body("Successful");
    }

}
