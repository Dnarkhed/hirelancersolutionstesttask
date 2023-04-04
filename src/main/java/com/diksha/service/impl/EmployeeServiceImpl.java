package com.diksha.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diksha.entity.Employee;
import com.diksha.exception.EmployeeNotFoundException;
import com.diksha.repository.EmployeeRepository;
import com.diksha.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;


	@Override
	public List<Employee> searchEmployeesByProperties(Long id, String firstName, String lastName, Double salary) {
		return employeeRepository.findAllByFirstName(id, firstName, lastName, salary);
	}
	
	@Override
	public Employee updateEmployee(Employee employee) {
		if(employee == null) {
			throw new EmployeeNotFoundException("Employee not found with proper details");
		}
		return employeeRepository.save(employee);
	}
	
	@Override
	public void addEmployee(Employee emp){
		employeeRepository.save(emp);
	}

	@Override
	public List<Employee> getAllEmployee() {	
		return employeeRepository.findAll();
	}
}
