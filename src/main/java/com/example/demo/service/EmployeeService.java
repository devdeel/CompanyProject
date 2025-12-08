package com.example.demo.service;

import com.example.demo.model.entity.Address;
import com.example.demo.model.entity.Department;
import com.example.demo.repository.AddressRepo;
import com.example.demo.repository.DepartmentRepo;
import com.example.demo.service.DTO.EmployeeDTO;
import com.example.demo.model.entity.Employee;
import com.example.demo.repository.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final AddressRepo addressRepo;
    private final DepartmentRepo departmentRepo;

    public List<EmployeeDTO> getEmployees() {
        return employeeRepo.findAll()
                .stream()
                .map(EmployeeDTO::fromEntityToDTO)
                .collect(Collectors.toList());
    }

    public EmployeeDTO getEmployee(Integer id) {
        return employeeRepo.findById(id)
                .map(EmployeeDTO::fromEntityToDTO)
                .orElse(null);
    }

    public EmployeeDTO saveEmployee(EmployeeDTO dto) {

        Employee employee = new Employee();
        employee.setFullName(dto.getFullName());
        employee.setSalary(dto.getSalary());
        employee.setRole(dto.getRole());

        if (dto.getAddress() != null) {
            if (dto.getAddress().getId() != null) {

                Address address = addressRepo.findById(dto.getAddress().getId())
                        .orElseThrow(() -> new RuntimeException("Address not found"));
                employee.setAddress(address);
            } else {

                Address newAddress = Address.toEntity(dto.getAddress());
                employee.setAddress(addressRepo.save(newAddress));
            }
        }

        if (dto.getDepartment() != null && dto.getDepartment().getDepartmentId() != null) {
            Department department = departmentRepo.findById(dto.getDepartment().getDepartmentId())
                    .orElseThrow(() -> new RuntimeException("Department not found"));
            employee.setDepartment(department);
        }

        Employee saved = employeeRepo.save(employee);
        return EmployeeDTO.fromEntityToDTO(saved);
    }

    public EmployeeDTO updateEmployee(EmployeeDTO dto) {

        Employee employee = employeeRepo.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employee.setFullName(dto.getFullName());
        employee.setSalary(dto.getSalary());
        employee.setRole(dto.getRole());


        if (dto.getAddress() != null) {
            if (dto.getAddress().getId() != null) {
                Address address = addressRepo.findById(dto.getAddress().getId())
                        .orElseThrow(() -> new RuntimeException("Address not found"));
                employee.setAddress(address);
            } else {
                Address newAddress = Address.toEntity(dto.getAddress());
                employee.setAddress(addressRepo.save(newAddress));
            }
        }

        if (dto.getDepartment() != null && dto.getDepartment().getDepartmentId() != null) {
            Department department = departmentRepo.findById(dto.getDepartment().getDepartmentId())
                    .orElseThrow(() -> new RuntimeException("Department not found"));
            employee.setDepartment(department);
        }

        Employee saved = employeeRepo.save(employee);
        return EmployeeDTO.fromEntityToDTO(saved);
    }

    public void deleteEmployee(Integer id) {
        employeeRepo.deleteById(id);
    }
}
