package com.onerivet.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.el.stream.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.onerivet.entity.Employee;
import com.onerivet.entitydto.EmployeeDto;
import com.onerivet.exception.DataNotFoundException;
import com.onerivet.exception.GlobalExceptionHandler;
import com.onerivet.repository.EmployeeRepository;

@Service
public class ServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	private EmployeeDto employeeToEmployeeDto(Employee employee) {
		
		EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
		return employeeDto;
	}
	
	private Employee employeeDtoToEmployee(EmployeeDto employeeDto) {
		Employee employee = modelMapper.map(employeeDto, Employee.class);
		return employee;
	}
	
	@Override
	public String addEmployee(EmployeeDto employeeDto) {
		Employee save = employeeRepository.save(employeeDtoToEmployee(employeeDto));
		if(save!=null) {
			return "save successfully";
		}return "not add";
	}

	@Override
	public List<EmployeeDto> findAll() {
		return employeeRepository.findAll().stream().map((employee)->employeeToEmployeeDto(employee)).collect(Collectors.toList());
	}

	@Override
	public EmployeeDto findById(long id) {
		//return employeeToEmployeeDto(employeeRepository.findById(id));
	
		//employeeRepository.findAll().
		 return employeeToEmployeeDto(employeeRepository.findById(id).orElseThrow(()->new DataNotFoundException("User Does Not Found")));
	}

	@Override
	public List<EmployeeDto> findByFlateHouseno(int flateHouseNo) {
		return employeeRepository.findByFlateHouseno(flateHouseNo).stream().map(no->employeeToEmployeeDto(no)).collect(Collectors.toList());
	}
	
	
	
	
}
