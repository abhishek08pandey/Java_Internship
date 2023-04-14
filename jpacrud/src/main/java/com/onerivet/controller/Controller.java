package com.onerivet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.dtoentity.DtoEmployee;
import com.onerivet.entity.Employee;
import com.onerivet.exception.DataNotFoundException;
import com.onerivet.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class Controller {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/add")
	public String addEmployee(@Valid @RequestBody DtoEmployee dtoEmployee) {
		System.out.println(dtoEmployee.isStatus());
		return employeeService.addEmployee(dtoEmployee);
	}
	
	@GetMapping("/get")
	public List<DtoEmployee> getAllRecords() {
		return employeeService.getAllRecords();
	}

	@GetMapping("/get-by-id")
	public DtoEmployee getOneRecords(@RequestParam int id) throws DataNotFoundException {
		return employeeService.getOneRecords(id);
	}

	@PutMapping("/update")
	public String updateRecord(@Valid @RequestBody DtoEmployee dtoEmployee) throws DataNotFoundException {
		return employeeService.updateRecord(dtoEmployee);
	}

	@DeleteMapping("/delete")
	public String deleteRecord(@Valid @RequestParam int id) throws DataNotFoundException {
		return employeeService.deleteById(id);
	}

	@GetMapping("/get-by-firstname")
	public List<DtoEmployee> getByFirstName(@RequestParam String firstName) {

		return employeeService.getByfirstName(firstName);
	}
	
	@GetMapping("/get-by-lastname")
	public List<DtoEmployee> getByLastName(@RequestParam String lastName) {

		return employeeService.getByLastName(lastName);
	}
	
	@GetMapping("/get-by-city")
	public List<DtoEmployee> getByCity(String city) {
		return employeeService.getByCity(city);
	}

	@GetMapping("/get-by-email")
	public DtoEmployee getByEmail(@RequestParam String email){
		
		return employeeService.getByEmail(email);
	}

	@GetMapping("/get-by-mobilenumber")
	public List<DtoEmployee> getByMobileNumber(String mobileNumber){
		return employeeService.getByMobileNumber(mobileNumber);
	}
	
	@GetMapping("/get-by-firstlastname")
	public List<DtoEmployee> getByFirstAndLastName(String firstName,String lastName){

		return employeeService.getByFirstAndLastName(firstName, lastName);
	}
	
	@GetMapping("/get-by-firstnamecity")
	public List<DtoEmployee> getByFirstNameAndCity( String firstName,  String city){
		return employeeService.getByFirstNameAndCity(firstName, city);
	}
	
	@GetMapping("/get-by-status")
	public List<DtoEmployee> getAllDataAndStatusTrue(boolean status){
		return employeeService.getAllDataAndStatusTrue(status);
	}
	
	@GetMapping("/get-by-age")
	public List<DtoEmployee> getAllage(int value1,int value2){
		return employeeService.getByAge(value1,value2);
	}
	
	@GetMapping("/get-bigger-age")
	public List<DtoEmployee> findByBiggerAge(int age){
		return employeeService.findByBiggerAge(age);
	}
	
	@GetMapping("/get-smaller-age")
	public List<DtoEmployee> findBySmallerAge(int age){
		return employeeService.findBySmallerAge(age);
	}

	@GetMapping("/get-firstname-by-city")
	public List<String> findByCity(String city){
		return employeeService.findByCity(city);
	}
}
