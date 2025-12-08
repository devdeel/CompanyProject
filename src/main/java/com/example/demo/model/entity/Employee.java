package com.example.demo.model.entity;

import com.example.demo.service.DTO.EmployeeDTO;
import jakarta.persistence.*;
import lombok.*;


@Table(name = "employee")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fullName;
    private Double salary;
    private String role;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    public static Employee toEntity(EmployeeDTO dto) {
        if (dto == null) return null;

        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setFullName(dto.getFullName());
        employee.setSalary(dto.getSalary());
        employee.setRole(dto.getRole());
        employee.setAddress(Address.toEntity(dto.getAddress()));
        employee.setDepartment(Department.toEntity(dto.getDepartment()));

        return employee;
    }
}
