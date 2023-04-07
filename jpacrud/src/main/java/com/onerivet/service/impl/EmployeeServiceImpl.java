package com.onerivet.service.impl;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.onerivet.dtoentity.DtoEmployee;
import com.onerivet.entity.Employee;
import com.onerivet.exception.DataNotFoundException;
import com.onerivet.repository.EmployeeRepository;
import com.onerivet.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

// get data from database	
	@Override
	public DtoEmployee employeeToDtoEmployee(Employee employee) {

		DtoEmployee dtoEmployee = new DtoEmployee();

		dtoEmployee.setId(employee.getId());
		dtoEmployee.setFirstName(employee.getFirstName());
		dtoEmployee.setLastName(employee.getLastName());
		dtoEmployee.setCity(employee.getCity());
		dtoEmployee.setEmail(employee.getEmail());
		dtoEmployee.setPassword(employee.getPassword());
		dtoEmployee.setMobileNumber(employee.getMobileNumber());

		return dtoEmployee;
	}

//get data from front end and json
	@Override
	public Employee dtoEmployeeToEmployee(DtoEmployee dtoEmployee) {

		Employee employee = new Employee();
		employee.setId(dtoEmployee.getId());
		employee.setFirstName(dtoEmployee.getFirstName());
		employee.setLastName(dtoEmployee.getLastName());
		employee.setCity(dtoEmployee.getCity());
		employee.setEmail(dtoEmployee.getEmail());
		employee.setPassword(dtoEmployee.getPassword());
		employee.setMobileNumber(dtoEmployee.getMobileNumber());

		return employee;
	}

	@Override
	public String addEmployee(DtoEmployee dtoEmployee) {

		// Employee employee = dtoEmployeeToEmployee(dtoEmployee);

		Employee saveEmployee = employeeRepository.save(dtoEmployeeToEmployee(dtoEmployee));

		if (saveEmployee != null) {
			return dtoEmployee.getFirstName() + "  Details add successfully";
		}
		return "Employee Details not save";
	}

// Baki
	@Override
	public List<DtoEmployee> getAllRecords() {

		return employeeRepository.findAll().stream().map((x) -> employeeToDtoEmployee(x)).collect(Collectors.toList());
	}

	@Override
	public String updateRecord(int id, DtoEmployee dtoEmployee) throws DataNotFoundException {
		DtoEmployee status = getOneRecords(id);

		if (status != null && id == dtoEmployee.getId()) {

			employeeRepository.save(dtoEmployeeToEmployee(dtoEmployee));
			return "Updated Successfully";
		}
		return "Not Found";
	}

	@Override
	public String deleteById(int id) throws DataNotFoundException {

		DtoEmployee dtoEmployee = getOneRecords(id);

		Employee employee = dtoEmployeeToEmployee(dtoEmployee);
		employeeRepository.delete(employee);

		return "Delete Successfully";
	}

// Ask
	@Override
	public DtoEmployee getOneRecords(int id) throws DataNotFoundException {

		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new DataNotFoundException("not found records"));
		return employeeToDtoEmployee(employee);
//		try {
//			Employee employee = employeeRepository.findById(id).get();
//			if (employee != null) {
//				DtoEmployee dtoEmployee = employeeToDtoEmploye(employee);
//
//				
//			}
//		} catch (Exception e) {
//			throw new DataNotFoundException("Data Not Found ");
//		}
//		return null;
	}

	@Override
	public List<DtoEmployee> getByfirstName(String firstName) {
		return employeeRepository.getByfirstName(firstName).stream().map(x -> employeeToDtoEmployee(x))
				.collect(Collectors.toList());
	}

	@Override
	public List<DtoEmployee> getByLastName(String lastName) {
		return employeeRepository.getEmployeeByLastName(lastName).stream().map(last -> employeeToDtoEmployee(last)).collect(Collectors.toList());
	}

	@Override
	public List<DtoEmployee> getByCity(String city){
		return employeeRepository.getByCity(city).stream().map(employeeCity->employeeToDtoEmployee(employeeCity)).collect(Collectors.toList());
	}
	@Override
	public DtoEmployee getByEmail(String email) {

		//Employee byEmail = employeeRepository.getEmployeeByEmail(email);
		//DtoEmployee dtoEmployee = employeeToDtoEmployee(employeeRepository.getEmployeeByEmail(email));
		return employeeToDtoEmployee(employeeRepository.getEmployeeByEmail(email));
	}
	
	@Override
	public List<DtoEmployee> getByMobileNumber(long mobileNumber){
		return employeeRepository.getByMobileNumber(mobileNumber).stream().map(mobile->employeeToDtoEmployee(mobile)).collect(Collectors.toList());
	}

	public List<DtoEmployee> getByFirstAndLastName(String firstName, String lastName){
		return employeeRepository.getByFirstNameAndLastName(firstName, lastName).stream().map(firstAndLastName->employeeToDtoEmployee(firstAndLastName)).collect(Collectors.toList());
	}
}
