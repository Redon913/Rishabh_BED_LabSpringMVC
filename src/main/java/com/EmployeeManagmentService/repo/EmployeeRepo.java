package com.EmployeeManagmentService.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmployeeManagmentService.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
