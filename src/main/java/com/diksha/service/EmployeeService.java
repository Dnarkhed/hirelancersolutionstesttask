package com.diksha.service;

import java.util.List;

import com.diksha.dto.EmployeeDto;

public interface EmployeeService {

	List<EmployeeDto> searchEmployeesByProperties( Long id,
			String firstName,
			 String lastName,
			Double salary);
}
