package com.EmployeeManagmentService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.EmployeeManagmentService.entity.Employee;
import com.EmployeeManagmentService.service.EmployeeService;

@Controller
public class EmployeeController {
	
	private EmployeeService eService;

	public EmployeeController(EmployeeService eService) {
		super();
		this.eService = eService;
	}
	@GetMapping("/employees")
	public String GetAllEmployee(Model model) {
		model.addAttribute("employees", this.eService.GetAllEmployees());
		return "employees";
	}
	
	@GetMapping("/employees/new")
	public String AddEmployee(Model model) {
		Employee emp = new Employee();
		model.addAttribute("emp", emp);
		return "addemployee";
	}
	
	@PostMapping("/employees/new")
	public String SaveEmployee(@ModelAttribute("emp") Employee emp) {
		eService.SaveEmployee(emp);
		return "redirect:/employees";
	}
	
	@GetMapping("/employees/edit/{id}")
	public String GetEmployeeById(@PathVariable Long id, Model model) {
		model.addAttribute("emp", eService.GetEmployeeById(id));
		return "editemployee";
	}
	
	@PostMapping("/employees/edit/{id}")
	public String EditEmployee(@PathVariable Long id, @ModelAttribute("emp") Employee emp, Model model) {
		Employee e = eService.GetEmployeeById(id);
		e.setID(id);
		e.setFirstname(emp.getFirstname());
		e.setLastname(emp.getLastname());
		e.setEmail(emp.getEmail());
		eService.EditEmployee(e);
		return "redirect:/employees";
	}
	
	@GetMapping("/employees/delete/{id}")
	public String DeleteEmployee(@PathVariable Long id) {
		eService.DeleteEmployee(id);
		return "redirect:/employees";
	}

}
