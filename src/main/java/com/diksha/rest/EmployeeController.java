package com.diksha.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diksha.entity.Employee;
import com.diksha.response.ResponseHandler;
import com.diksha.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("employees")
@Slf4j
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("addEmployee")
	public ResponseEntity<?> addEmployee(@RequestBody Employee emp) {
		log.info("addEmployee : Started");
		employeeService.addEmployee(emp);
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
	
	@GetMapping("getAllEmployee")
	public List<Employee> getAllEmployee() {
		log.info("getAllEmployee : Started");
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("searchAllEmployeeByFilter")
	public List<Employee> searchEmployee(@RequestParam(name = "id", required = false) Long id,
			@RequestParam(name = "firstName", required = false) String firstName,
			@RequestParam(name = "lastName", required = false) String lastName,
			@RequestParam(name = "salary", required = false) Double salary) {
		
		log.info("searchEmployee : Started");
		return employeeService.searchEmployeesByProperties(id, firstName, lastName, salary);
		
	}
	
	@PatchMapping("updateEmployee")
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee) {
		log.info("updateEmployee : Started");
		
		  Employee updatedEmployee = this.employeeService.updateEmployee(employee);
		  return ResponseHandler.generateResponse("Success", HttpStatus.OK, updatedEmployee);
		
	}
	
}
