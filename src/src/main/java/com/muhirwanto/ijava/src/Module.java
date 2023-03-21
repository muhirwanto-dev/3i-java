package com.muhirwanto.ijava.src;

import java.util.function.Consumer;

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

    private final String[] moduleNames = 
    {
        "Odd And Even",
        "Minimum Payment",
        "Maximum Total Height",
        "Home Stay",
        "Bonus"
    };

    public static void RunModule1()
    {
        
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
                RunModule1();
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