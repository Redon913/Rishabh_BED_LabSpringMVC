package com.EmployeeManagmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.EmployeeManagmentService.entity.Employee;
import com.EmployeeManagmentService.repo.EmployeeRepo;

@SpringBootApplication
public class EmployeeManagmentServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagmentServiceApplication.class, args);
	}
	
	@Autowired
	private EmployeeRepo eRepo;
	
	@Override
	public void run(String... args) throws Exception{
		if(eRepo.count() == 0) {
			Employee e1 = new Employee("Rishabh", "Chauhan", "something@some.com");
			eRepo.save(e1);
			
			Employee e2 = new Employee("Bruce", "Wayne", "Batman@bat.com");
			eRepo.save(e2);
			
			Employee e3 = new Employee("Tony", "Stark", "IronMan@avenger.com");
			eRepo.save(e3);
			
			Employee e4 = new Employee("Captian", "India", "indiancap@avenger.com");
			eRepo.save(e4);
		}
	}

}
