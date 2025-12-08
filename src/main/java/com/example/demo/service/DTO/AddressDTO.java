package com.example.demo.service.DTO;

import com.example.demo.model.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddressDTO {

    private Integer id;
    private String city;
    private String streetName;
    private String zipCode;

    //Mapping
    public static AddressDTO fromEntityToDTO(Address entity) {
        if (entity == null) return null;

        return AddressDTO.builder()
                .id(entity.getId())
                .city(entity.getCity())
                .streetName(entity.getStreetName())
                .zipCode(entity.getZipCode())
                .build();
    }
}




