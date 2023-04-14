package com.onerivet.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.entitydto.EmployeeDto;
import com.onerivet.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/add-employee")
	public String addEmployeeDto(@Valid @RequestBody EmployeeDto employeeDto) {
		return employeeService.addEmployeeDto(employeeDto);
	}
	
	@RequestMapping("/truncate")
	public String dropTable() {
		return employeeService.dropTable();
	}
	
	@GetMapping("/get")
	public List<EmployeeDto> findAll(){
		return employeeService.findAll();
	}
	
	@GetMapping("/get-by-innerjoin")
	public List<EmployeeDto>findByInnerJoin(int id){
		return employeeService.findByInnerJoin(id);
	}
	
//	@GetMapping("/get-by-state")
//	public List<EmployeeDto>findByState(String state){
//		return employeeService.findByState(state);
//	}
}
