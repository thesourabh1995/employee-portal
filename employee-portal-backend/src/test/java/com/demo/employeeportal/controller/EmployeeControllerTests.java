package com.demo.employeeportal.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.employeeportal.entity.Employee;
import com.demo.employeeportal.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeControllerTests {

	@InjectMocks
	EmployeeController controller = new EmployeeController();
	
	@Mock
	EmployeeService service;
	
	List<Employee> employeeList = new ArrayList<Employee>();
	Employee employee = new Employee();
	
	@Before
	public void setUp() throws ParseException{
		MockitoAnnotations.initMocks(this);
		employee.setFirstName("Sourabh");
		employee.setLastName("Mishra");
		employee.setGender("Male");
		employee.setDepartment("Engineering");
		employee.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1995-08-27"));
		employeeList.add(employee);
	}
	
	@Test
	public void getAllEmployeesTest() {
		Mockito.when(service.getAllEmployees()).thenReturn(employeeList);
		List<Employee> employees = controller.getAllEmployees();
		assertEquals(employeeList, employees);
	}
	
	@Test
	public void createEmployeeTest() {
		Mockito.when(service.createEmployee(employee)).thenReturn(employee);
		Employee response = controller.createEmployee(employee);
		assertEquals(employee, response);
	}
	
	@Test
	public void createEmployeeNullTest() {
		assertNull(controller.createEmployee(null));
	}
	
}
