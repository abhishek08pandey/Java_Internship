package com.onerivet.service;

import java.util.List;

import com.onerivet.entitydto.EmployeeDto;

public interface EmployeeService {

	public String addEmployeeDto(EmployeeDto employeeDto);
	
	public String dropTable();
	
	public List<EmployeeDto> findAll();
	
	public List<EmployeeDto> findByInnerJoin(int id);
	
	//public List<EmployeeDto> findByState(String state);
}
