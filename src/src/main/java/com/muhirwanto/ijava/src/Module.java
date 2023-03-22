package com.muhirwanto.ijava.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.muhirwanto.ijava.src.Repository.DepartmentRepository;
import com.muhirwanto.ijava.src.Repository.EmployeeRepository;

public class Module
{
    public enum ModuleEnum
    {
        OddAndEven,
        MinimumPayment,
        MaximumTotalHeight,
        HomeStay,
        Bonus
    }
    
    private static final Logger log = LoggerFactory.getLogger(Module.class);

    private final String[] moduleNames = 
    {
        "Odd And Even",
        "Minimum Payment",
        "Maximum Total Height",
        "Home Stay",
        "Bonus"
    };

    private DepartmentRepository departmentRepository;
    private EmployeeRepository employeeRepository;

    public Module(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository)
    {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    public static void RunModule1(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository)
    {
        String[] departmentIds = departmentRepository.GetAllDepartmentId();
        String[] departmentNames = departmentRepository.GetAllDepartmentName();
        Map<String, Integer> departmentCounterHash = new Hashtable<String, Integer>();

        log.info("Raw entries");
        for (int idx = 0; idx < departmentIds.length; idx++)
        {
            int count = employeeRepository.GetEmployeeCount(departmentIds[idx]);
            departmentCounterHash.put(departmentNames[idx], count);

            log.info("Name: " + departmentNames[idx] + " | Count: " + Integer.toString(count));
        }

        List<Entry<String, Integer>> entryList = new ArrayList<Entry<String, Integer>>(departmentCounterHash.entrySet());
        // Using % 2 != 0 make it reversed, IDK why.
        Collections.sort(entryList, Comparator.comparing(hash -> hash.getValue() % 2 == 0));

        log.info("\n");
        log.info("Sorted entries");
        for (Entry<String,Integer> entry : entryList)
        {
            log.info("Name: " + entry.getKey() + " | Count: " + Integer.toString(entry.getValue()));
        }
    }

    /**
     * @param moduleId
     * @return
     */
    public String Run(ModuleEnum moduleId)
    {
        switch (moduleId)
        {
            case OddAndEven:
                RunModule1(departmentRepository, employeeRepository);
            break;
            case MinimumPayment:
            break;
            case MaximumTotalHeight:
            break;
            case HomeStay:
            break;
            case Bonus:
            break;
        }

        var id = moduleId.ordinal();
        return String.format("Module %d (%s) opened!", id, moduleNames[id]);
    }
}