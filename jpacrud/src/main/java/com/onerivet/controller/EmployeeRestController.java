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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.dtoentity.DtoEmployee;
import com.onerivet.entity.Employee;
import com.onerivet.exception.DataNotFoundException;
import com.onerivet.service.EmployeeService;

import jakarta.validation.Valid;

//@RestController
//@RequestMapping("/employee")
public class EmployeeRestController {
	
		@Autowired
		private EmployeeService employeeService;

//		@Autowired
//		privlate EmployeeRepository employeeRepository;

		@PostMapping("/add")
		public String addEmployee(@Valid @RequestBody DtoEmployee dtoEmployee) {
			System.out.println(dtoEmployee.isStatus());
			return employeeService.addEmployee(dtoEmployee);
		}
		
		@GetMapping("/get")
		public List<DtoEmployee> getAllRecords() {
			return employeeService.getAllRecords();
		}

		@GetMapping("/get/{id}")
		public DtoEmployee getOneRecords(@PathVariable("id") int id) throws DataNotFoundException {
			return employeeService.getOneRecords(id);
		}

		@PutMapping("/update")
		public String updateRecord(@Valid @RequestBody DtoEmployee dtoEmployee) throws DataNotFoundException {
			return employeeService.updateRecord(dtoEmployee);
		}

		@DeleteMapping("/delete/{id}")
		public String deleteRecord(@Valid @PathVariable int id) throws DataNotFoundException {
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
		public List<DtoEmployee> getByMobileNumber(String mobileNumber){
			return employeeService.getByMobileNumber(mobileNumber);
		}
		
		@GetMapping("/get-by-firstlastname/{firstName}/{lastName}")
		public List<DtoEmployee> getByFirstAndLastName(@PathVariable String firstName,@PathVariable String lastName){

			return employeeService.getByFirstAndLastName(firstName, lastName);
		}
		
		@GetMapping("/get-by-firstnamecity/{firstName}/{city}")
		public List<DtoEmployee> getByFirstNameAndCity(@PathVariable String firstName, @PathVariable String city){
			return employeeService.getByFirstNameAndCity(firstName, city);
		}
		
		@GetMapping("/get-by-status/{status}")
		public List<DtoEmployee> getAllDataAndStatusTrue(@PathVariable boolean status){
			return employeeService.getAllDataAndStatusTrue(status);
		}
//		@RequestMapping("/try")
//		public Page<Employee> tryNew() {
////			long count = employeeRepository.count();
////			return count;
//			
////			Page<Employee> findAll = employeeRepository.findAll(Pageable.ofSize(9));
////			return findAll;
//			
//		}

	}