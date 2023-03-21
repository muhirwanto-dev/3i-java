package com.muhirwanto.ijava.src.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.muhirwanto.ijava.src.Repository.DepartmentRepository;
import com.muhirwanto.ijava.src.Repository.EmployeeRepository;

@RestController
public class MainController
{
    private DepartmentRepository departmentRepository;
    private EmployeeRepository employeeRepository;

    public MainController(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository)
    {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }
}
