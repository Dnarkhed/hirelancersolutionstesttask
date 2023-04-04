package com.diksha.exception;

public class EmployeeNotFoundException extends RuntimeException {

	public EmployeeNotFoundException() {
		super();
	}

	public EmployeeNotFoundException(String invalide_student_details) {
		super(invalide_student_details);
	}
}
