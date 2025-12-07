package com.example.demo.controller;

import com.example.demo.model.entity.DTO.EmployeeDTO;
import com.example.demo.model.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@CrossOrigin("*")

public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/allEmployees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/getEmployee")
    public EmployeeDTO getEmployee(@RequestParam Integer id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping("/saveEmployee")
    public EmployeeDTO save(@RequestBody EmployeeDTO employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/updateEmployee")
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employee) {
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/deleteEmployee")
    public void deleteEmployee(@RequestParam Integer id) {
        employeeService.deleteEmployee(id);

    }

}
