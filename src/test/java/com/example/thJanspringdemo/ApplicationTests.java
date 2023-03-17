package com.example.thJanspringdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
	
	@Autowired
	EmployeeController empController;
	

	@Test
	void contextLoads() {
	}
	
	@Test
	void testSayHelloMethod() {
		assertEquals("Hello world from sayhello() Method", empController.sayhello());
	}
	
	@Test
	void testCreateEmployee () {
		Employee emp = new Employee(103,"Lithvik",10000);
		assertEquals(emp.getEmpId(), empController.createEmployee(emp).getEmpId());
	}
		
	}


