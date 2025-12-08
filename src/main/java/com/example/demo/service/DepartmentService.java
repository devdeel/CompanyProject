package com.example.demo.service;

import com.example.demo.model.entity.Department;
import com.example.demo.repository.DepartmentRepo;
import com.example.demo.service.DTO.DepartmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    public List<DepartmentDTO> getDepartments() {
        return departmentRepo.findAll()
                .stream()
                .map(DepartmentDTO::fromEntityToDTO)
                .toList();
    }

    public DepartmentDTO getDepartment(Integer id) {
        return departmentRepo.findById(id)
                .map(DepartmentDTO::fromEntityToDTO)
                .orElse(null);
    }

    public DepartmentDTO saveDepartment(DepartmentDTO dto) {
        Department department = Department.toEntity(dto);
        Department saved = departmentRepo.save(department);
        return DepartmentDTO.fromEntityToDTO(saved);
    }

    public DepartmentDTO updateDepartment(DepartmentDTO dto) {

        if (!departmentRepo.existsById(dto.getDepartmentId())) {
            throw new RuntimeException("Department not found with id: " + dto.getDepartmentId());
        }

        Department department = Department.toEntity(dto);
        Department saved = departmentRepo.save(department);
        return DepartmentDTO.fromEntityToDTO(saved);
    }

    public void deleteDepartment(Integer id) {
        departmentRepo.deleteById(id);
    }
}












