package com.demo.employeeportal.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.employeeportal.entity.Employee;
import com.demo.employeeportal.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository repository;
	
	@Override
	public List<Employee> getAllEmployees(){
		List<Employee> employees = repository.findAll();
		employees.sort(Comparator.comparing(Employee::getFirstName));
		return employees;
	}
	
	@Override
	public Employee createEmployee(Employee employee) {
		return repository.save(employee);
	}
}
