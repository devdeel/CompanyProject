package com.example.demo.api.repository;

import com.example.demo.model.entity.Employee;
import com.example.demo.repository.EmployeeRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;


import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)


public class EmployeeRepoTest {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Test
    public void testSaveEmployee() {

        // Arrange
        Employee emp = Employee.builder()
                .fullName("Hadeel Alshammari")
                .role("Senior Manager")
                .salary(20000.0)
                .build();

        // Act
        Employee savedEmp = employeeRepo.save(emp);

        // Assert
        assertThat(savedEmp.getId()).isNotNull();

        assertThat(savedEmp.getFullName())
                .isEqualTo("Hadeel Alshammari");
        assertThat(savedEmp.getRole())
                .isEqualTo("Senior Manager");
        assertThat(savedEmp.getSalary())
                .isEqualTo(20000.0);
    }
}
