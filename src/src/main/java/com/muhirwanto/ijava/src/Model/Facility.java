package com.muhirwanto.ijava.src.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Facility
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int Id;

    public String Name;
    public float Price;

    public Facility(String Name, float price)
    {
        this.Name = Name;
        this.Price = price;
    }
}
