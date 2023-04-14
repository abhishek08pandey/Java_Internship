package com.onerivet.service;

import java.util.List;

import com.onerivet.dtoentity.DtoEmployee;
import com.onerivet.entity.Employee;
import com.onerivet.exception.DataNotFoundException;

public interface EmployeeService {
	
	public String addEmployee(DtoEmployee dtoEmployee);
	
	public List<DtoEmployee> getAllRecords();
	
	public DtoEmployee getOneRecords(int id) throws DataNotFoundException;
	
	public String updateRecord(DtoEmployee employee) throws DataNotFoundException;
	
	public String deleteById(int id) throws DataNotFoundException;
	
	public List<DtoEmployee> getByfirstName(String firstName);
	
	public List<DtoEmployee> getByLastName(String lastName);
	
	public List<DtoEmployee> getByCity(String city);
	
	public DtoEmployee getByEmail(String email);
	
	public List<DtoEmployee> getByMobileNumber(String mobileNumber);
	
	public List<DtoEmployee> getByFirstAndLastName(String firstName, String lastName);
	
	public List<DtoEmployee> getByFirstNameAndCity(String firstName, String city);

	public List<DtoEmployee> getAllDataAndStatusTrue(boolean status);
	
	public List<DtoEmployee> getByAge(int value1, int value2);
	
	public List<DtoEmployee> findByBiggerAge(int age);
	
	public List<DtoEmployee> findBySmallerAge(int age);
	
	public List<String>  findByCity(String city);
	
}
