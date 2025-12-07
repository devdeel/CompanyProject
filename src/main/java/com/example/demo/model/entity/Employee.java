package com.example.demo.model.entity;

import com.example.demo.model.entity.DTO.EmployeeDTO;
import jakarta.persistence.*;
import lombok.*;

// ORM = OBJECT RELATIONAL MAPPING:
// from java class to a database table!
@Table(name = "employee")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Employee { // 1 2 3 4 id auto inc

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullName;
    private Double salary;
    private String role;

    public static Employee toEntity(EmployeeDTO dto) {
        return Employee.builder()
                .id(dto.getId())
                .fullName(dto.getFullName())
                .role(dto.getRole())
                .build();
    }

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;


    @ManyToOne
    @JoinColumn(name ="department_id")
    private Department department;



}
