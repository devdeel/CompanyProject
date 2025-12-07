package com.example.demo.model.entity.DTO;

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
    //    private Double salary;
    private String role;


    //Mapping
    public static EmployeeDTO fromEntityToDTO(Employee entity) {
        return EmployeeDTO.builder()
                .id(entity.getId())
                .fullName(entity.getFullName())
//                .salary(entity.getSalary())
                .role(entity.getRole())
                .build();
    }
}
