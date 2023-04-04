package com.diksha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.diksha.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query(value = "SELECT e FROM Employee as e WHERE (e.id = :id OR :id IS NULL) and (e.lastName like %:lastName% OR :lastName IS NULL) and (e.firstName like %:firstName% OR :firstName IS NULL) and (e.salary = :salary OR :salary IS NULL)")
	List<Employee> findAllByFirstName(Long id, String firstName, String lastName, Double salary);
	
}
