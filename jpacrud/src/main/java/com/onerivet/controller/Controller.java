package com.onerivet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.dtoentity.DtoEmployee;
import com.onerivet.exception.DataNotFoundException;
import com.onerivet.service.EmployeeService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/employee")
public class Controller {

	@Autowired
	private EmployeeService employeeService;

//	@Autowired
//	privlate EmployeeRepository employeeRepository;

	@PostMapping("/add")
	public String addEmployee(@RequestBody DtoEmployee dtoEmployee) {
		
		return employeeService.addEmployee(dtoEmployee);
	}
	
	@GetMapping("/get")
	public List<DtoEmployee> getAllRecords() {
		return employeeService.getAllRecords();
	}

	@GetMapping("/get/{id}")
	public DtoEmployee getOneRecords(@PathVariable int id) throws DataNotFoundException {
		return employeeService.getOneRecords(id);
	}

	@PutMapping("/update/{id}")
	public String updateRecord(@PathVariable int id, @RequestBody DtoEmployee dtoEmployee) throws DataNotFoundException {
		return employeeService.updateRecord(id, dtoEmployee);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteRecord(@PathVariable int id) throws DataNotFoundException {
		return employeeService.deleteById(id);
	}

	@GetMapping("/get-by-firstname/{firstName}")
	public List<DtoEmployee> getByFirstName(@PathVariable("firstName") String firstName) {

		return employeeService.getByfirstName(firstName);
	}
	
	@GetMapping("/get-by-lastname/{lastName}")
	public List<DtoEmployee> getByLastName(@PathVariable("lastName") String lastName) {

		return employeeService.getByLastName(lastName);
	}
	
	@GetMapping("/get-by-city/{city}")
	public List<DtoEmployee> getByCity(@PathVariable("city")String city) {
		return employeeService.getByCity(city);
	}

	@GetMapping("/get-by-email/{email}")
	public DtoEmployee getByEmail(@PathVariable("email")String email){
		
		return employeeService.getByEmail(email);
	}

	@GetMapping("/get-by-mobilenumber")
	public List<DtoEmployee> getByMobileNumber(long mobileNumber){
		return employeeService.getByMobileNumber(mobileNumber);
	}
	
	@GetMapping("/get-by-firstlastname")
	public List<DtoEmployee> getByFirstAndLastName(String firstName, String lastName){
		return employeeService.getByFirstAndLastName(firstName, lastName);
	}
//	@RequestMapping("/try")
//	public Page<Employee> tryNew() {
////		long count = employeeRepository.count();
////		return count;
//		
////		Page<Employee> findAll = employeeRepository.findAll(Pageable.ofSize(9));
////		return findAll;
//		
//	}

}
