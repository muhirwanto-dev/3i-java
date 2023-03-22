package com.muhirwanto.ijava.src.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.muhirwanto.ijava.src.Model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> 
{
    @Query(value = "SELECT COUNT(department_id) FROM employee WHERE department_id=:departmentId", nativeQuery = true)
    public Integer GetEmployeeCount(@Param(value = "departmentId") String departmentId);
}
