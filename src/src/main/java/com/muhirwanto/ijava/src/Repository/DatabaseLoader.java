package com.muhirwanto.ijava.src.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.muhirwanto.ijava.src.Model.Department;
import com.muhirwanto.ijava.src.Model.Employee;

@Configuration
public class DatabaseLoader
{
    private static final Logger log = LoggerFactory.getLogger(DatabaseLoader.class);
    
    @Bean
    CommandLineRunner InitDepartment(DepartmentRepository repository)
    {
        Department[] departments =
        {
            new Department("d001", "Finance"),
            new Department("d002", "Sales"),
            new Department("d003", "Production"),
            new Department("d004", "HRD"),
            new Department("d005", "QA"),
            new Department("d006", "IT"),
        };

        repository.saveAll(Arrays.asList(departments));

        return args -> log.info("Department repository has been loaded.");
    }

    
    @Bean
    CommandLineRunner InitEmployee(EmployeeRepository repository)
    {
        Employee[] employees =
        {
            new Employee("101", "d002", Date.valueOf(LocalDate.parse("1997-11-30")), Date.valueOf(LocalDate.parse("9999-01-01"))),
            new Employee("102", "d001", Date.valueOf(LocalDate.parse("1993-12-27")), Date.valueOf(LocalDate.parse("9999-01-01")))
        };

        repository.saveAll(Arrays.asList(employees));

        return args -> log.info("Department repository has been loaded.");
    }
}
