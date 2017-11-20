package com.sampleproject.dao;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Repository;

import com.sampleproject.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	
	ArrayList<Employee> empData = new ArrayList<Employee>();
	
	public EmployeeDAOImpl(){
		Employee emp1 = new Employee(1,"Aishwarya","Software Engineer");
		
		Employee emp2 = new Employee(2,"Vaibhav","Trainee");
		
		empData.add(emp1);
		empData.add(emp2);
	}
	
	public ArrayList<Employee> getAllEmployees() {
		return empData;
	}
	
	public Employee getEmployeeById(int id) throws Exception{
		Iterator<Employee> itr = empData.iterator();
		Employee employee= null;
		while(itr.hasNext()){
			Employee current = itr.next();
			int empId = current.getId();
			if(id == empId){
				employee = current;
				break;
			}
		}
		if(employee == null) {
			throw new Exception("Employee Id:" + id + " not found");
		}
		return employee;
	}
	
	public Employee addEmployee(Employee emp) throws Exception{
		Iterator<Employee> itr = empData.iterator();
		Employee  employee= null;
		int id = emp.getId();
		while(itr.hasNext()){
			Employee current = itr.next();
			if(id == current.getId()){
				employee = current;
				break;
			}
		}
		if(employee == null){
			empData.add(emp);
			return emp;
		}else{
			throw new Exception("Employee Id:" + emp.getId() + "already exists");
		}
	}
	
	public Employee updateEmployee(Employee emp) throws Exception{
		Iterator<Employee> itr = empData.iterator();
		Employee employee = null;
		int id = emp.getId();
		while(itr.hasNext()){
			Employee current = itr.next();
			if(id == current.getId()){
				current.setId(emp.getId());
				current.setName(emp.getName());
				current.setDesignation(emp.getDesignation());
				employee = current;
				break;
			}
		}
		if(employee == null) {
			throw new Exception("Employee Id:" + emp.getId() + " not found");
		}else{
			return employee;
		}
	}
	
	public Employee deleteEmployee(int id) throws Exception {
		Iterator<Employee> itr = empData.iterator();
		Employee employee = null;
		while(itr.hasNext()){
			Employee current = itr.next();
			if(id == current.getId()){
				employee = current;
				break;
			}
		}
		if(employee == null) {
			throw new Exception("Employee Id:" + id + " not found");
		}else{
			empData.remove(employee);
			return employee;
		}
	}
}
