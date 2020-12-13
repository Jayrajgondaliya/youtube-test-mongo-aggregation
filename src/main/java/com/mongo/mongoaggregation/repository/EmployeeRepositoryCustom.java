package com.mongo.mongoaggregation.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepositoryCustom {

	public int getNumberOfEmployeeWithSalaryMoreThan(int salary);

	public int getNumberOfEmployeeWithSalaryLessThan(int salary);
}
