package com.example.demo.service.DTO;

import com.example.demo.model.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDTO {

    private Integer id;
    private String fullName;
    private double salary;
    private String role;
    private AddressDTO address;
    private DepartmentDTO department;

    public static EmployeeDTO fromEntityToDTO(Employee entity) {
        if (entity == null) return null;

        return EmployeeDTO.builder()
                .id(entity.getId())
                .fullName(entity.getFullName())
                .salary(entity.getSalary())
                .role(entity.getRole())
                .address(AddressDTO.fromEntityToDTO(entity.getAddress()))
                .department(DepartmentDTO.fromEntityToDTO(entity.getDepartment()))
                .build();
    }
}
