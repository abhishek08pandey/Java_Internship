package com.onerivet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.onerivet.dtoentity.DtoEmployee;
import com.onerivet.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	public List<Employee> getByfirstName(String firstName);
	
	public List<Employee> getEmployeeByLastName(String lastName);
	
	public List<Employee> getByCity(String city);
	
	@Query("SELECT e FROM Employee e WHERE e.email=:email")
	public Employee getEmployeeByEmail(@Param("email") String email);
	
	public List<Employee> getByMobileNumber(long mobileNumber);
	
	public List<Employee> getByFirstNameAndLastName(String firsName, String lastName);
}
