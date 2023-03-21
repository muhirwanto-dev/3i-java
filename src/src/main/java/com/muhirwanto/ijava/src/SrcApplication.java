package com.muhirwanto.ijava.src;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SrcApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(SrcApplication.class, args);
	}

	@GetMapping("module")
	public String OpenModule(@RequestParam(name = "name", defaultValue = "1") int index)
	{
		return String.format("Module %d opened!", index);
	}
}
