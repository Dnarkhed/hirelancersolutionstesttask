package com.diksha.service;

import java.util.List;

import com.diksha.entity.Employee;

public interface EmployeeService {

	List<Employee> searchEmployeesByProperties(Long id, String firstName, String lastName, Double salary);

	Employee updateEmployee(Employee employee);

	void addEmployee(Employee emp);

	List<Employee> getAllEmployee();
}
