package com.onerivet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.onerivet.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	//public Employee findById(int id);
	
	//@Query("SELECT e.Address FROM Employee.Address e.Address WHERE e.Address.flateHouseNo=:flateHouseNo")
	@Query(value="SELECT * FROM employee e WHERE flate_house_no=:flateHouseNo", nativeQuery = true)
	public List<Employee> findByFlateHouseno(int flateHouseNo);
}
