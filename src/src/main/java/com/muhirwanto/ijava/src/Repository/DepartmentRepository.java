package com.muhirwanto.ijava.src.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.muhirwanto.ijava.src.Model.Department;

public interface DepartmentRepository extends CrudRepository<Department, Integer>
{
    @Query(value = "SELECT department_id FROM department", nativeQuery = true)
    public String[] GetAllDepartmentId();

    @Query(value = "SELECT name FROM department", nativeQuery = true)
    public String[] GetAllDepartmentName();
}
