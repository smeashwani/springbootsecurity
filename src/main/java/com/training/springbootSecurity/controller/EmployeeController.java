package com.training.springbootSecurity.controller;

import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
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
	
	@GetMapping("/pricipal")
	public Principal getPrincipal(Principal principal){
		return principal;
	}
	
	@GetMapping("/user")
	public Map<String, Object>  getUser(@AuthenticationPrincipal OAuth2User principal){
		return Collections.singletonMap("name", principal.getAttribute("login"));
	}
}
