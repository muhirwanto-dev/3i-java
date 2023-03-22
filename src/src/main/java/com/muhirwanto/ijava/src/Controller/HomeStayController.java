package com.muhirwanto.ijava.src.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.muhirwanto.ijava.src.Model.Facility;
import com.muhirwanto.ijava.src.Model.ReservationData;
import com.muhirwanto.ijava.src.Model.Room;
import com.muhirwanto.ijava.src.Repository.FacilityRepository;
import com.muhirwanto.ijava.src.Repository.ReservationDataRepository;
import com.muhirwanto.ijava.src.Repository.RoomRepository;

@RestController
@RequestMapping
public class HomeStayController
{
    private static final Logger log = LoggerFactory.getLogger(HomeStayController.class);
    
    @Autowired
    private FacilityRepository facilityRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ReservationDataRepository reservationRepository;

    @GetMapping(path = "/register")
    public @ResponseBody ReservationData Register(@RequestParam String userName,
        @RequestParam String roomName,
        @RequestParam List<String> facilities)
    {
        ReservationData data = new ReservationData();

        data.UserName = userName;

        var facilityIterable = facilityRepository.findAll();
        var facilityList = new ArrayList<Facility>();

        facilityIterable.forEach(facilityList::add);

        for (String facilityName : facilities) 
        {
            var facility = facilityList.stream().filter(f -> f.Name == facilityName).toList();

            if (facility.isEmpty())
            {
                log.warn("{} doesn't exist in the table, remove it", facilityName);
            }
            else
            {
                data.FacilityIds.add(facility.get(0).Id);
            }
        }

        var roomIterable = roomRepository.findAll();
        var roomList = new ArrayList<Room>();

        roomIterable.forEach(roomList::add);

        var room = roomList.stream().filter(r -> r.Name == roomName).toList();
        if (room.isEmpty())
        {
            log.warn("{} doesn't exist in the table, use default room");
        }
        else
        {
            data.RoomId = room.get(0).Id;
        }

        reservationRepository.save(data);

        return data;
    }
}