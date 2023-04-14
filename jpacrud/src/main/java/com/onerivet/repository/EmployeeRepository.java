package com.onerivet.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onerivet.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	public List<Employee> getByfirstNameAndStatusTrue(String firstName);
	
	public List<Employee> getEmployeeByLastName(String lastName);
	
	public List<Employee> getByCity(String city);
	
	@Query("SELECT e FROM Employee e WHERE e.email=:email")
	public Employee getEmployeeByEmail(@Param("email") String email);
	
	public Optional<Employee> getByMobileNumber(String mobileNumber);
	
	public List<Employee> getByStatus(boolean status);
	
	public List<Employee> getByFirstNameAndLastName(String firsName, String lastName);
	
	public List<Employee> getByFirstNameAndCity(String firstName, String city);
	
	@Query("SELECT e FROM Employee e WHERE e.status=:status")
	public List<Employee> getAllDataAndStatusTrue(@Param("status") boolean status);
	
	@Modifying
//	@Query(value = "SELECT * FROM Employees e WHERE e.age BETWEEN ? AND ?", nativeQuery = true)
	@Query("SELECT e FROM Employee e WHERE e.age >=:value1 AND e.age <=:value2")
	public List<Employee> findByAgeBetween(int value1, int value2);
	
	@Query("SELECT e FROM Employee e WHERE e.age>=:age")
	public List<Employee> findByBiggerAge(int age);
	
	@Query("SELECT e FROM Employee e WHERE e.age<=:age")
	public List<Employee> findBySmallerAge(int age);
	
	//public List<Employee> findAllFirstName();
	
	@Query("SELECT employee.firstName FROM Employee employee WHERE employee.city=:city")
	public List<String> findByCity(@Param("city") String city);
	
	
}
