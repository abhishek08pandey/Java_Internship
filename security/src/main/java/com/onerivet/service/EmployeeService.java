package com.onerivet.service;

import java.util.List;
import java.util.Map;

import com.onerivet.entitydto.EmployeeDto;

public interface EmployeeService {

	public String addEmployeeDto(EmployeeDto employeeDto);
	
	public String dropTable();
	
	public List<EmployeeDto> findAll();
	
	public EmployeeDto getById(long id);
	
	public String delete(long id);
	
	public String update(EmployeeDto employeeDto);
	
	public List<Map<String, String>> findByInnerJoin(int id);
	
	public List<EmployeeDto> findByState(String state);
}
