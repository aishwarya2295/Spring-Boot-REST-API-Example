package com.sampleproject.service;

import java.util.ArrayList;
import com.sampleproject.model.Employee;

public interface EmployeeService {
	public ArrayList<Employee> getAllEmployees();
	public Employee getEmployeeById(int id) throws Exception;
	public Employee addEmployee(Employee emp) throws Exception;
	public Employee updateEmployee(Employee emp) throws Exception;
	public Employee deleteEmployee(int id) throws Exception;
}