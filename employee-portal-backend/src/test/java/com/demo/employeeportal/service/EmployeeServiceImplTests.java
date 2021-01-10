package com.demo.employeeportal.service;


import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.demo.employeeportal.repository.EmployeeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeServiceImplTests {
	@InjectMocks
	EmployeeServiceImpl service = new EmployeeServiceImpl();
	
	@Mock
	EmployeeRepository repository;
	
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
	public void createEmployeeTest() {
		Mockito.when(repository.save(employee)).thenReturn(employee);
		Employee response = service.createEmployee(employee);
		assertNotNull(response);
		assertEquals(service.createEmployee(employee).getFirstName(), "Sourabh");
	}
	
	@Test
	public void getAllEmployees() {
		Mockito.when(repository.findAll()).thenReturn(employeeList);
		List<Employee> list = service.getAllEmployees();
		assertNotNull(list);
		assertEquals(list.size(), employeeList.size());
	}

}
