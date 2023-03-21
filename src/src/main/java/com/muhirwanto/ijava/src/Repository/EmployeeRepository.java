package com.muhirwanto.ijava.src.Repository;

import org.springframework.data.repository.CrudRepository;

import com.muhirwanto.ijava.src.Model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> 
{
}
