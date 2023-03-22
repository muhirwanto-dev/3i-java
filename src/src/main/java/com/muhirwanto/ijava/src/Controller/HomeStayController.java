package com.muhirwanto.ijava.src.Controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.muhirwanto.ijava.src.Model.ReservationData;

@RestController
@RequestMapping
public class HomeStayController
{
    @GetMapping(path = "/register")
    public @ResponseBody ReservationData Register(@RequestParam String userName)
    {
        ReservationData data = new ReservationData();

        data.UserName = userName;

        return data;
    }
}