package com.onerivet.service.impl;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private ModelMapper modelMapper;

	private List<DtoEmployee> collect;

// get data from database	
	private DtoEmployee employeeToDtoEmployee(Employee employee) {

		DtoEmployee dtoEmployee = modelMapper.map(employee, DtoEmployee.class);
		
//		DtoEmployee dtoEmployee new DtoEmployee();
//		System.out.println("in employee: "+employee.isStatus());
//		dtoEmployee.setId(employee.getId());
//		dtoEmployee.setFirstName(employee.getFirstName());
//		dtoEmployee.setLastName(employee.getLastName());
//		dtoEmployee.setCity(employee.getCity());
//		dtoEmployee.setEmail(employee.getEmail());
//		dtoEmployee.setPassword(employee.getPassword());
//		dtoEmployee.setMobileNumber(employee.getMobileNumber());
//		dtoEmployee.setAge(employee.getAge());
		dtoEmployee.setStatus(employee.isStatus());

		return dtoEmployee;
	}

//get data from front end and json
	private Employee dtoEmployeeToEmployee(DtoEmployee dtoEmployee) {

		Employee employee = modelMapper.map(dtoEmployee, Employee.class);
		
//		Employee employee = new Employee();
//		System.out.println("in dto employee: "+dtoEmployee.isStatus());
//		employee.setId(dtoEmployee.getId());
//		employee.setFirstName(dtoEmployee.getFirstName());
//		employee.setLastName(dtoEmployee.getLastName());
//		employee.setCity(dtoEmployee.getCity());
//		employee.setEmail(dtoEmployee.getEmail());
//		employee.setPassword(dtoEmployee.getPassword());
//		employee.setMobileNumber(dtoEmployee.getMobileNumber());
//		employee.setAge(dtoEmployee.getAge());
		employee.setStatus(dtoEmployee.isStatus());

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

	@Override
	public List<DtoEmployee> getAllRecords() {

		return employeeRepository.findAll().stream().map((x) -> employeeToDtoEmployee(x)).collect(Collectors.toList());
	}

	@Override
	public String updateRecord(DtoEmployee dtoEmployee) throws DataNotFoundException {
		DtoEmployee record = getOneRecords(dtoEmployee.getId());

		if (record != null) {

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
		return employeeRepository.getByfirstNameAndStatusTrue(firstName).stream().map((fName)->employeeToDtoEmployee(fName)).collect(Collectors.toList());
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
	public List<DtoEmployee> getByMobileNumber(String mobileNumber){
		return employeeRepository.getByMobileNumber(mobileNumber).stream().map(mobile->employeeToDtoEmployee(mobile)).collect(Collectors.toList());
		//return employeeRepository.getByMobileNumber(mobileNumber).orElseThrow(()->new DataNotFoundException("Mobile Number not match with any records"));
		 
	}

	public List<DtoEmployee> getByFirstAndLastName(String firstName, String lastName){
		return employeeRepository.getByFirstNameAndLastName(firstName, lastName).stream().map(firstAndLastName->employeeToDtoEmployee(firstAndLastName)).collect(Collectors.toList());
	}

	@Override
	public List<DtoEmployee> getByFirstNameAndCity(String firstName, String city) {
		return employeeRepository.getByFirstNameAndCity(firstName, city).stream().map(firstNameAndCity->employeeToDtoEmployee(firstNameAndCity)).collect(Collectors.toList());
	}

	@Override
	public List<DtoEmployee> getAllDataAndStatusTrue(boolean status) {
		return employeeRepository.getAllDataAndStatusTrue(status).stream().map(findAllStatusTrue->employeeToDtoEmployee(findAllStatusTrue)).collect(Collectors.toList());
	}

//	@Override
//	public List<DtoEmployee> getByAge(int value1, int value2) {
//		
//		return employeeRepository.getByAge(value1, value2).stream().map(cage->employeeToDtoEmployee(cage)).collect(Collectors.toList());
//	}
	
	public List<DtoEmployee> getByAge(int value1,int value2){
		 List<DtoEmployee> collect = this.employeeRepository.findByAgeBetween(value1,value2).stream().map(this:: employeeToDtoEmployee).collect(Collectors.toList());
		 return collect;
	}
	
	public List<DtoEmployee> findByBiggerAge(int age){
		return employeeRepository.findByBiggerAge(age).stream().map(ages->employeeToDtoEmployee(ages)).collect(Collectors.toList());
	}
	
	public List<DtoEmployee> findBySmallerAge(int age){
		return employeeRepository.findBySmallerAge(age).stream().map(ages->employeeToDtoEmployee(ages)).collect(Collectors.toList());
	}
	
	
	public List<String>  findByCity(String city){
		List<String> allRecords = employeeRepository.findByCity(city);
		return allRecords;
	}
}
