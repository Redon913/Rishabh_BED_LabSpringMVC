package com.EmployeeManagmentService.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.EmployeeManagmentService.entity.Employee;
import com.EmployeeManagmentService.repo.EmployeeRepo;
import com.EmployeeManagmentService.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepo eRepo;

	public EmployeeServiceImpl(EmployeeRepo eRepo) {
		super();
		this.eRepo = eRepo;
	}

	@Override
	public List<Employee> GetAllEmployees() {
		return this.eRepo.findAll();
	}

	@Override
	public Employee SaveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return this.eRepo.save(emp);
	}

	@Override
	public Employee GetEmployeeById(Long Id) {
		return eRepo.findById(Id).get();
	}

	@Override
	public Employee EditEmployee(Employee emp) {
		return eRepo.save(emp);
	}

	@Override
	public void DeleteEmployee(Long id) {
		eRepo.deleteById(id);
	}

}
