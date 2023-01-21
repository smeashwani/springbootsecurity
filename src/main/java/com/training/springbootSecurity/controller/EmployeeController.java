package com.training.springbootSecurity.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.springbootSecurity.model.Employee;

@RestController
public class EmployeeController {

	@GetMapping("getAllEmployee")
	public List<Employee> getAllEmployee(){
		return List.of(new Employee("first","name"),new Employee("last","name"));
	}
	
	@GetMapping("/")
	public List<Employee> getRoot(){
		return List.of();
	}
}
