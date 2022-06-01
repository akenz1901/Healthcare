package com.healthcare.doctor_onboarding.service.mapping;

import com.healthcare.doctor_onboarding.data.model.Address;
import com.healthcare.doctor_onboarding.data.model.dto.AddressDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface AddressDtoMapping{

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void mapDtoAddressToExistingDoctorAddress(AddressDto addressDto, @MappingTarget Address address);
}
