package com.onerivet.services.impl;

import java.util.List;

import com.onerivet.entitydto.EmployeeDto;

public interface EmployeeService {

	public String addEmployee(EmployeeDto employeeDto);
	
	public List<EmployeeDto> findAll();
	
	public EmployeeDto findById(long id);
	
	public List<EmployeeDto> findByFlateHouseno(int flateHouseNo);
}
