package com.demo.employeeportal.service;

import java.util.List;

import com.demo.employeeportal.entity.Employee;

public interface EmployeeService {
 public List<Employee> getAllEmployees();
 public Employee createEmployee(Employee employee);
}
