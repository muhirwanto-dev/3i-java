package com.muhirwanto.ijava.src.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Department
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer Id;

    public String DepartmentId;
    public String Name;

    public Department(String departmentId, String name)
    {
        this.DepartmentId = departmentId;
        this.Name = name;
    }
}
