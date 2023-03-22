package com.muhirwanto.ijava.src;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.muhirwanto.ijava.src.Repository.DepartmentRepository;
import com.muhirwanto.ijava.src.Repository.EmployeeRepository;

@Configuration
public class AppConfig
{
    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Bean
    public Module Module()
    {
        return new Module(this.departmentRepository, this.employeeRepository);
    }   
}
