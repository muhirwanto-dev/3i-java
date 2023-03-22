package com.muhirwanto.ijava.src.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.sql.Date;
import java.util.List;

@Entity
public class ReservationData
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int Id;

    public String UserName;
    public Date CheckInDate;
    public Date CheckOutDate;
    public int RoomId;
    public List<Integer> FacilityIds;
}
