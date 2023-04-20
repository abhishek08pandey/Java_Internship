package com.onerivet.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;
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

		//employee.getAddress().setEmployee(employee);
		Employee employee1 = employeeRepository.save(employee);

		if (employee1 != null) {
			return employee.getName() + " : Details save successfully";
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

		return employeeRepository.findAll().stream().map(list -> employeeToEmployeeDto(list))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto getById(long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow();

		return employeeToEmployeeDto(employee);
	}

	@Override
	public String delete(long id) {
// 1st way use jsonIgnore for employee field in address class		
		EmployeeDto oldEmployeeDto = getById(id);
		Employee employee2 = employeeDtoToEmployee(oldEmployeeDto);
		
		
//		System.out.println(employee2);
//		System.out.println(employee2.getAddress().getEmployee());

		employeeRepository.delete(employee2);

// 2nd way use direct repository method findById();		
//		Employee employee = employeeRepository.findById(id).orElseThrow();
//		 employeeRepository.delete(employee);

		return "delete Successfully";

	}

	@Override
	public List<Map<String, String>> findByInnerJoin(int id) {
		// TODO Auto-generated method stub
		// return
		// employeeRepository.findByInnerJoin(id).stream().map(list->employeeToEmployeeDto(list)).collect(Collectors.toList());
		return employeeRepository.findByInnerJoin(id);
	}

	@Override
	public String update(EmployeeDto newEmployeeDto) {

		EmployeeDto oldEmployeeDto = getById(newEmployeeDto.getId());

		// oldEmployeeDto.setAddress(employeeDto.getAddress());

		if (newEmployeeDto.getName() != null) {
			oldEmployeeDto.setName(newEmployeeDto.getName());
		}
		if (newEmployeeDto.getAddress() != null) {
			if (newEmployeeDto.getAddress().getCity() != null) {
				oldEmployeeDto.getAddress().setCity(newEmployeeDto.getAddress().getCity());
			}
			if (newEmployeeDto.getAddress().getState() != null) {
				oldEmployeeDto.getAddress().setState(newEmployeeDto.getAddress().getState());
			}
		}
		if (newEmployeeDto.getEmail() != null) {
			oldEmployeeDto.setEmail(newEmployeeDto.getEmail());
		}
		if (newEmployeeDto.getPassword() != null) {
			oldEmployeeDto.setPassword(newEmployeeDto.getPassword());
		}
		if (newEmployeeDto.getMobile() != null) {
			oldEmployeeDto.setMobile(newEmployeeDto.getMobile());
		}

		// Employee oldEmployee =
		// employeeDtoToEmployee(getById(newEmployeeDto.getId()));

		Employee employee = employeeDtoToEmployee(oldEmployeeDto);

		Employee updateEmployee = employeeRepository.save(employee);

		if (updateEmployee != null) {
			return updateEmployee.getName() + " update successfully";
		}
		return "Not Update";
	}

	@Override
	public List<EmployeeDto> findByState(String state) {

		return employeeRepository.findByState(state).stream().map(address -> employeeToEmployeeDto(address))
				.collect(Collectors.toList());
	}

}
