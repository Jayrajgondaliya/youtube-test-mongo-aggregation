package com.mongo.mongoaggregation.controller;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.mongoaggregation.model.Employee;
import com.mongo.mongoaggregation.service.EmployeeService;

@RestController
public class Controller {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> getAll() {
		return employeeService.getAll();
	}

	@GetMapping("/employee")
	public Document getCounts(@RequestParam(name = "salary") int salary) {
		return employeeService.geCount(salary);
	}

}
