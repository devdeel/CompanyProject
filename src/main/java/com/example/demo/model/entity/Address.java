package com.example.demo.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Address {

    @Id
    @GeneratedValue
    private Integer addressId;
    private String city;
    private String streetName;
    private String houseNumber;
    private String zipCode;

    @OneToOne (mappedBy = "address")
    private Employee employee;


}