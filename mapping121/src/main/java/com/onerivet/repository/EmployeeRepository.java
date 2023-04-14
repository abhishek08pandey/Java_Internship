package com.onerivet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.onerivet.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	@Query(value="TRUNCATE TABLE employee_details", nativeQuery=true)
	public String dropTable();
	
	//@Query("SELECT e FROM Employee e WHERE e.address=:state")
	//@Query(value="SELECT * FROM employee_details e where e.name=name", nativeQuery = true) //for name correct
	@Query(value="SELECT employee_details.name name, employee_details.mobile mobile, address.city city FROM employee_details  JOIN address ON employee_details.id=address.?", nativeQuery = true)
	public List<Employee> findByInnerJoin(@Param ("id") int id);
	
	//public List<Employee> findByState(String name);
}
