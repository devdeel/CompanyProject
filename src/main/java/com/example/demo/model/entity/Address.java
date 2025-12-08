package com.example.demo.model.entity;

import com.example.demo.service.DTO.AddressDTO;
import jakarta.persistence.*;
import lombok.*;


@Table(name = "address")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String city;
    private String streetName;

    private String zipCode;

    @OneToOne(mappedBy = "address")
    private Employee employee;



    public static Address toEntity(AddressDTO dto) {
        if (dto == null) return null;

        Address address = new Address();
        address.setId(dto.getId());
        address.setCity(dto.getCity());
        address.setStreetName(dto.getStreetName());
        address.setZipCode(dto.getZipCode());

        return address;
    }

}