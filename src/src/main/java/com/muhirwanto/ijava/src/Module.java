package com.muhirwanto.ijava.src;

import java.util.ArrayList;
import java.util.Arrays;
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

    /**
     * @param moduleId index of module, start with 0
     * @return string value to be written in web page
     */
    public String Run(ModuleEnum moduleId)
    {
        String result = "No module found!";

        switch (moduleId)
        {
            case OddAndEven:
                result = RunModule1();
            break;
            case MinimumPayment:
                result = RunModule2();
            break;
            case MaximumTotalHeight:
                result = RunModule3();
            break;
            case HomeStay:
            break;
            case Bonus:
            break;
        }

        var id = moduleId.ordinal();
        return String.format("Module %d (%s) opened! Result: %s", id, moduleNames[id], result);
    }    

    public String RunModule1()
    {
        // The data is prepared via Dependency Injection (@Bean) at DatabaseLoader

        String[] departmentIds = departmentRepository.GetAllDepartmentId();
        String[] departmentNames = departmentRepository.GetAllDepartmentName();
        Map<String, Integer> departmentCounterHash = new Hashtable<String, Integer>();

        log.info("Raw entries");
        for (int idx = 0; idx < departmentIds.length; idx++)
        {
            // a) Get employee count from SQL table based on department id
            int count = employeeRepository.GetEmployeeCount(departmentIds[idx]);

            departmentCounterHash.put(departmentNames[idx], count);

            log.info("Name: " + departmentNames[idx] + " | Count: " + count);
        }

        List<Entry<String, Integer>> entryList = new ArrayList<Entry<String, Integer>>(departmentCounterHash.entrySet());

        // b) Sort existing list based on employee count, odd number then even number
        // Using % 2 != 0 make it reversed, IDK why.
        Collections.sort(entryList, Comparator.comparing(hash -> hash.getValue() % 2 == 0));

        String result = "";

        log.info("\n");
        log.info("Sorted entries");
        for (Entry<String,Integer> entry : entryList)
        {
            var logStr = "Name: " + entry.getKey() + " | Count: " + entry.getValue();

            result += logStr + ";";

            log.info(logStr);
        }

        return result;
    }

    public String RunModule2()
    {
        // Input condition
        final int minBuyCount = 4;
        Integer[] input = {3, 6, 2, 5, 1};

        if (input.length < minBuyCount)
        {
            throw new IllegalArgumentException("Array length should greater or equal to " + minBuyCount);
        }

        // a) Sort in reverse order to get maximum discount at 'minBuyCount'-th item
        Arrays.sort(input, Collections.reverseOrder());

        String result = "Sum of [";
        int sum = 0;

        for (Integer value : input)
        {
            if (value == input[minBuyCount - 1])
            {
                continue;
            }

            // b) Sum sortened list except free item
            sum += value;
            result += value;

            if (value != input[input.length - 1])
            {
                result += ",";
            }
        }

        result += "] - index of " + minBuyCount + " = " + sum;

        return result;
    }

    public String RunModule3()
    {
        // Input condition
        int[] A = {1, 4, 5};
        int[] B = {3, 4, 9};

        // a) Calculate the total height cross arrays
        int maxTotalHeight = Math.max(CalculateTotalHeightCrossArrays(A, B), CalculateTotalHeightCrossArrays(B, A));

        return "The maximum value is " + maxTotalHeight;
    }

    private int CalculateTotalHeightCrossArrays(int[] left, int[] right)
    {
        if (left.length != right.length)
        {
            throw new IllegalArgumentException("Array length are different!");
        }

        int result = 0;

        for (int idx = 0; idx < left.length; idx++)
        {
            if (idx % 2 == 0)
            {
                result += left[idx];
            }
            else
            {
                result += right[idx];
            }
        }

        return result;
    }
}