package com.healthcare.doctor_onboarding.data.model.dto;

import lombok.Data;

@Data
public class AddressDto {
    private String homeAddress;
    private String lga;
    private String state;
}
