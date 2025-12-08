package com.example.demo.controller;

import com.example.demo.service.DTO.DepartmentDTO;
import com.example.demo.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@CrossOrigin("*")
@RequiredArgsConstructor

public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/all")
    public List<DepartmentDTO> getDepartments() {
        return departmentService.getDepartments();
    }

    @GetMapping("/{id}")
    public DepartmentDTO getDepartment(@PathVariable Integer id) {
        return departmentService.getDepartment(id);
    }

    @PostMapping("/create")
    public DepartmentDTO createDepartment(@RequestBody DepartmentDTO dto) {
        return departmentService.saveDepartment(dto);
    }

    @PutMapping("/update/{id}")
    public DepartmentDTO updateDepartment(@PathVariable Integer id, @RequestBody DepartmentDTO dto) {
        dto.setDepartmentId(id);
        return departmentService.updateDepartment(dto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDepartment(@PathVariable Integer id) {
        departmentService.deleteDepartment(id);
    }
}