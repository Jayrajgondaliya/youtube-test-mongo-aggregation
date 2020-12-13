package com.mongo.mongoaggregation.service;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.mongoaggregation.model.Employee;
import com.mongo.mongoaggregation.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	public Document geCount(int salary) {
		int countLessThanSalary = employeeRepository.getNumberOfEmployeeWithSalaryLessThan(salary);
		int countMoreThanSalary = employeeRepository.getNumberOfEmployeeWithSalaryMoreThan(salary);
		return new Document("More than salary", countMoreThanSalary).append("Less Than salary", countLessThanSalary);
	}

}
