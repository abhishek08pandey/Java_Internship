package com.onerivet.restcontroller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.entity.Address;
import com.onerivet.entitydto.AddressDto;
import com.onerivet.entitydto.EmployeeDto;
import com.onerivet.repository.AddressRepository;
import com.onerivet.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@PostMapping("/add-employee")
	public String addEmployeeDto(@Valid @RequestBody EmployeeDto employeeDto) {
		return employeeService.addEmployeeDto(employeeDto);
	}
	
	@RequestMapping("/truncate")
	public String dropTable() {
		return employeeService.dropTable();
	}
	
	@GetMapping("/get")
	public List<EmployeeDto> findAll(){
		return employeeService.findAll();
	}
	
	@GetMapping("/get-by-id")
	public EmployeeDto getByid(long id){
		return employeeService.getById(id);
	}
	
	@DeleteMapping("/delete-by-id")
	public String delete(long id){
		return employeeService.delete(id);
	}
	
	@PutMapping("/update")  
	public String update(@RequestBody EmployeeDto employeeDto){
		return employeeService.update(employeeDto);
	}
	
	@GetMapping("/get-by-innerjoin")
	public List<Map<String, String>> findByInnerJoin(int id){
		 return employeeService.findByInnerJoin(id);
	}
	
	@GetMapping("/get-by-state")
	public List<EmployeeDto>findByState(String state){
		return employeeService.findByState(state);
	}
	
	@GetMapping("/get-by-address")
	public List<AddressDto> findAll1(){
		return addressRepository.findAll().stream().map((ne)->modelMapper.map(ne, AddressDto.class)).collect(Collectors.toList());
	}
}
