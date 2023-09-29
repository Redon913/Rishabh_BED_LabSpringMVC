package com.EmployeeManagmentService.service;

import java.util.List;

import com.EmployeeManagmentService.entity.Employee;

public interface EmployeeService {
	List<Employee> GetAllEmployees();
	
	Employee SaveEmployee(Employee emp);
	
	Employee GetEmployeeById(Long Id);
	
	Employee EditEmployee(Employee emp);
	
	void DeleteEmployee(Long id);
}
