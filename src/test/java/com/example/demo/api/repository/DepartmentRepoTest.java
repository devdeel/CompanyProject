package com.example.demo.api.repository;

import com.example.demo.model.entity.Department;
import com.example.demo.repository.DepartmentRepo;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class DepartmentRepoTest {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Test
    public void testSaveAddress() {
        Department dep = Department.builder()
                .name("Software Development")
                .build();


        Department savedDep = departmentRepo.save(dep);

        assertThat(savedDep.getId()).isNotNull();
        assertThat(savedDep.getName())
                .isEqualTo("Software Development");
    }
}