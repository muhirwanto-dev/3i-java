package com.muhirwanto.ijava.src.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.sql.Date;

@Entity
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int Id;
    
    public String EmployeeId;
    public String DepartmentId;
    public Date FromDate;
    public Date ToDate;

    public Employee(String employeeId, String departmentId, Date fromDate, Date toDate)
    {
        this.EmployeeId = employeeId;
        this.DepartmentId = departmentId;
        this.FromDate = fromDate;
        this.ToDate = toDate;
    }
}
