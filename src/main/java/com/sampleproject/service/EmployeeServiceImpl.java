package com.sampleproject.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampleproject.dao.EmployeeDAO;
import com.sampleproject.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDAO employeeDao;

	@Override
	public ArrayList<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();		
	}

	@Override
	public Employee getEmployeeById(int id) throws Exception {
		return employeeDao.getEmployeeById(id);
	}

	@Override
	public Employee addEmployee(Employee emp) throws Exception {
		return employeeDao.addEmployee(emp);
	}

	@Override
	public Employee updateEmployee(Employee emp) throws Exception {
		return employeeDao.updateEmployee(emp);
	}

	@Override
	public Employee deleteEmployee(int id) throws Exception {
		return employeeDao.deleteEmployee(id);
	}
	
	
}
