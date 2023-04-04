package com.diksha.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diksha.dto.EmployeeDto;
import com.diksha.entity.Employee;
import com.diksha.repository.EmployeeRepository;
import com.diksha.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<EmployeeDto> searchEmployeesByProperties(Long id, String firstName, String lastName, Double salary) {
		List<EmployeeDto> employeeDtos = new ArrayList<>();
		if(id != null) {
			Employee employee = employeeRepository.findById(id).get();
			EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
			employeeDtos.add(employeeDto);
		}
		else if(firstName != null) {
			List<Employee> employees = employeeRepository.findAllByFirstName(firstName);
			//List<EmployeeDto> employeeDtis = employees.stream().map(employee ->e) 
		}else {
			List<Employee> employees= employeeRepository.findAll();
		}
		return employeeDtos;
	}
	

}
