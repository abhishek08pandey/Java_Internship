package com.onerivet.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onerivet.entity.Employee;
import com.onerivet.entitydto.EmployeeDto;
import com.onerivet.repository.EmployeeRepository;
import com.onerivet.service.EmployeeService;

@Service
public class ServiceImpl implements EmployeeService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
// Exchanging Object between Entity to EntityDto	
	private Employee employeeDtoToEmployee(EmployeeDto employeeDto) {
		return modelMapper.map(employeeDto, Employee.class);
	}
	private EmployeeDto employeeToEmployeeDto(Employee employee) {
		return modelMapper.map(employee, EmployeeDto.class);
	}
	
	
	@Override
	public String addEmployeeDto(EmployeeDto employeeDto) {
		Employee employee = employeeDtoToEmployee(employeeDto);
		
		employee.getAddress().setEmployee(employee);
		 Employee employee1 = employeeRepository.save(employee);
		 
		 if(employee1!=null) {
			 return employee.getName()+" : Details save successfully";
		 }
		 return "Invalid Details";
	}
	
	@Override
	public String dropTable() {
		employeeRepository.dropTable();
		return "Table Drop";
	}
	
	@Override
	public List<EmployeeDto> findAll() {
		
		 return employeeRepository.findAll().stream().map(list->employeeToEmployeeDto(list)).collect(Collectors.toList());
	}
	
	@Override
	public List<EmployeeDto> findByInnerJoin(int id) {
		// TODO Auto-generated method stub
		return employeeRepository.findByInnerJoin(id).stream().map(list->employeeToEmployeeDto(list)).collect(Collectors.toList());
	}
	
//	@Override
//	public List<EmployeeDto> findByState(String state) {
//		
//		return employeeRepository.findByState(state).stream().map(address->employeeToEmployeeDto(address)).collect(Collectors.toList());
//	}
	

}
