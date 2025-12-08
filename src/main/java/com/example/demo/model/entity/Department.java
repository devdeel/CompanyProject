package com.example.demo.model.entity;

import com.example.demo.service.DTO.DepartmentDTO;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Table(name = "department")
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;


    @OneToMany(mappedBy = "department")
    private List<Employee> employees;


        public static Department toEntity(DepartmentDTO dto) {
            if (dto == null) return null;

            return Department.builder()
                    .name(dto.getName())
                    .build();
        }


    }




