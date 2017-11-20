package com.sampleproject.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sampleproject.model.Employee;
import com.sampleproject.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl employeeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ArrayList<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Employee getEmployeeById(@PathVariable Integer id) throws Exception {
		return employeeService.getEmployeeById(id);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Employee addEmployee(@RequestBody Employee emp) throws Exception {
		return employeeService.addEmployee(emp);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Employee updateEmployee(@RequestBody Employee emp) throws Exception {
		return employeeService.updateEmployee(emp);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Employee deleteEmployee(@PathVariable Integer id) throws Exception{
		return employeeService.deleteEmployee(id);
	}
}