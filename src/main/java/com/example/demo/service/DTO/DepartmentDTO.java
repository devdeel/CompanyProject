package com.example.demo.service.DTO;

import com.example.demo.model.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class DepartmentDTO {

    private Integer departmentId;
    private String name;


    //Mapping
    public static DepartmentDTO fromEntityToDTO(Department entity) {
        if (entity == null) return null;
        return DepartmentDTO.builder()
                .departmentId(entity.getId())
                .name(entity.getName())
                .build();
    }
}





