package com.healthcare.doctor_onboarding.data.model;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import org.hibernate.annotations.CascadeType;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String homeAddress;

    private String lga;

    private String state;
}
