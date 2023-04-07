package com.onerivet.service;

import java.util.List;

import com.onerivet.dtoentity.DtoEmployee;
import com.onerivet.entity.Employee;
import com.onerivet.exception.DataNotFoundException;

public interface EmployeeService {
	
	public DtoEmployee employeeToDtoEmployee(Employee employee);
	
	public Employee dtoEmployeeToEmployee(DtoEmployee employee);

	public String addEmployee(DtoEmployee dtoEmployee);
	
	public List<DtoEmployee> getAllRecords();
	
	public DtoEmployee getOneRecords(int id) throws DataNotFoundException;
	
	public String updateRecord(int id, DtoEmployee employee) throws DataNotFoundException;
	
	public String deleteById(int id) throws DataNotFoundException;
	
	public List<DtoEmployee> getByfirstName(String firstName);
	
	public List<DtoEmployee> getByLastName(String lastName);
	
	public List<DtoEmployee> getByCity(String city);
	
	public DtoEmployee getByEmail(String email);
	
	public List<DtoEmployee> getByMobileNumber(long mobileNumber);
	
	public List<DtoEmployee> getByFirstAndLastName(String firstName, String lastName);

	
}
