package com.onerivet.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.onerivet.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
//
//	@Query(value="TRUNCATE TABLE employee_details", nativeQuery=true)
//	public String dropTable();
//	
//	//@Query(value="SELECT e.name name, e.mobile mobile, a.city city FROM employee_details e INNER JOIN address a ON e.id = a.employee_id  WHERE e.id=?", nativeQuery = true)// we get all records with List
//	@Query("SELECT e.name name, a.city city FROM Employee e JOIN e.address a WHERE e.id=:id")// we get single and latest record even used of List
//	public List<Map<String, String>> findByInnerJoin(@Param ("id") int id);
//	
//	@Query("SELECT e FROM Employee e INNER JOIN e.address a WHERE a.state=:state")
//	public List<Employee> findByState(@Param ("state") String state);
}
