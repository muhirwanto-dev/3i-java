package com.muhirwanto.ijava.src;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.muhirwanto.ijava.src.Module.ModuleEnum;

@SpringBootApplication
@RestController
public class SrcApplication
{
	@Autowired
	private Module module;

	public static void main(String[] args) 
	{
		SpringApplication.run(SrcApplication.class, args);
	}

	@GetMapping("module")
	public String OpenModule(@RequestParam(name = "name", defaultValue = "1") int index)
	{
		return module.Run(ModuleEnum.values()[index]);
	}
}
