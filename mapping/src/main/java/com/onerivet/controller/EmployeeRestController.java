package com.onerivet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.entitydto.EmployeeDto;
import com.onerivet.services.impl.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")

public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/add")
	public String addEmploye(@Valid @RequestBody EmployeeDto employeeDto) {
		return employeeService.addEmployee(employeeDto);
	}
	
	@GetMapping("/get")
	public List<EmployeeDto> welcome() {
		return employeeService.findAll();
	}
	
	@GetMapping("/get-by-id")
	public EmployeeDto findById(@RequestParam long id){
		return employeeService.findById(id);
	}
	
	@GetMapping("/get-by-flateno")
	public List<EmployeeDto> findByFlateHouseno(int flateHouseNo){
		return employeeService.findByFlateHouseno(flateHouseNo);
	}
	
	
}
