package com.example.thJanspringdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	
	@Autowired
	EmployeeRepository empRepository;
	
    @GetMapping("/sayhello")
	public String sayhello() {
	return "Hello world from sayhello() Method";
}
    
    @GetMapping("/registerEmployee")
    public Employee registerEmployee () {
    	Employee emp = new Employee(101,"Sharma",10000);
    	Employee savedEmp = empRepository.save(emp);
        //return "Employee" + savedEmp.getEmpName() + "is stored in the database";
    	return savedEmp;
    }
    
    @GetMapping("/getEmployee")
    public String getEmployee() {
    	Employee emp = empRepository.findById(101).get();
    	return emp.getEmpName() + " | " + emp.getSalary();
    }
    
    @PostMapping("/createEmployee")
    public Employee createEmployee (@RequestBody Employee emp) {
    	return empRepository.save(emp);
    	
    }
    
    @GetMapping("/getEmployee/{empId}")
    public Employee getEmployeeDetails(@PathVariable(value="empId")int empId) {
    	return empRepository.findById(empId).get();
    }
    
    
}

