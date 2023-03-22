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
import com.muhirwanto.ijava.src.Model.Facility;
import com.muhirwanto.ijava.src.Model.Room;

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
            new Employee("102", "d001", Date.valueOf(LocalDate.parse("1993-12-27")), Date.valueOf(LocalDate.parse("9999-01-01"))),
            new Employee("103", "d001", Date.valueOf(LocalDate.parse("1993-02-22")), Date.valueOf(LocalDate.parse("1993-10-27"))),
            new Employee("104", "d005", Date.valueOf(LocalDate.parse("1995-05-31")), Date.valueOf(LocalDate.parse("9999-01-01"))),
            new Employee("105", "d006", Date.valueOf(LocalDate.parse("1994-10-11")), Date.valueOf(LocalDate.parse("1995-11-30"))),
            new Employee("106", "d005", Date.valueOf(LocalDate.parse("1996-03-03")), Date.valueOf(LocalDate.parse("9999-01-01"))),
            new Employee("107", "d004", Date.valueOf(LocalDate.parse("1991-07-24")), Date.valueOf(LocalDate.parse("2000-05-29"))),
            new Employee("108", "d003", Date.valueOf(LocalDate.parse("1999-08-18")), Date.valueOf(LocalDate.parse("9999-01-01"))),
            new Employee("109", "d004", Date.valueOf(LocalDate.parse("1992-08-25")), Date.valueOf(LocalDate.parse("9999-01-01"))),
            new Employee("110", "d006", Date.valueOf(LocalDate.parse("1994-11-02")), Date.valueOf(LocalDate.parse("1996-12-21"))),
            new Employee("111", "d006", Date.valueOf(LocalDate.parse("1999-01-01")), Date.valueOf(LocalDate.parse("9999-01-01"))),
        };

        repository.saveAll(Arrays.asList(employees));

        return args -> log.info("Department repository has been loaded.");
    }

    @Bean
    CommandLineRunner InitHomeStay(FacilityRepository facilityRepository, RoomRepository roomRepository)
    {
        Facility[] facilities =
        {
            new Facility("Breakfast", 10000),
            new Facility("Extra bed", 50000),
            new Facility("Smoking room", 0),
            new Facility("2nd floor", 0),
        };

        facilityRepository.saveAll(Arrays.asList(facilities));

        Room[] rooms =
        {
            new Room("Single", 119000),
            new Room("Twin", 119000),
            new Room("Deluxe", 199000),
            new Room("Family", 249000),
        };

        roomRepository.saveAll(Arrays.asList(rooms));

        return args -> log.info("HomeStay facilities & rooms repository has been loaded");
    }
}
