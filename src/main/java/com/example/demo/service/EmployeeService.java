package com.example.demo.service;

import com.example.demo.model.entity.DTO.EmployeeDTO;
import com.example.demo.model.entity.Employee;
import com.example.demo.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;


    public List<Employee> getEmployees() {
        return employeeRepo.findAll();
    }

    public EmployeeDTO getEmployee(Integer id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        return employee.map(EmployeeDTO::fromEntityToDTO).orElse(null);
    }

    public EmployeeDTO saveEmployee(EmployeeDTO dto) {
        Employee employee = Employee.toEntity(dto);
        Employee savedEmployee = employeeRepo.save(employee);
        return EmployeeDTO.fromEntityToDTO(savedEmployee);
    }

    public void deleteEmployee(Integer id) {
        employeeRepo.deleteById(id);
    }

    public EmployeeDTO updateEmployee(EmployeeDTO dto) {
        Employee employee = Employee.toEntity(dto);
        Employee savedEmployee = employeeRepo.save(employee);
        return EmployeeDTO.fromEntityToDTO(savedEmployee);
    }

}
