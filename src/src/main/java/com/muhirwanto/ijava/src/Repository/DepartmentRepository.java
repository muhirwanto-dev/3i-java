package com.muhirwanto.ijava.src.Repository;

import org.springframework.data.repository.CrudRepository;

import com.muhirwanto.ijava.src.Model.Department;

public interface DepartmentRepository extends CrudRepository<Department, Integer>
{
}
