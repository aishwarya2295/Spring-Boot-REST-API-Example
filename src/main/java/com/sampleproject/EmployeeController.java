package com.sampleproject;

import java.util.HashMap;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	HashMap<Integer, Employee> empData = new HashMap<Integer, Employee>();

	@RequestMapping(value = "/employee")
	public HashMap<Integer, Employee> employees() {
		Employee emp1 = new Employee();
		Employee emp2 = new Employee();

		emp1.setId(1);
		emp1.setName("Aishwarya");
		emp1.setDesignation("S/w Engineer");
		empData.put(1, emp1);
		System.out.println("id of 1nd :"+emp1.getId());;

		emp2.setId(2);
		emp2.setName("Aisha");
		emp2.setDesignation("S/w Engineer");
		empData.put(2, emp2);
		System.out.println("id of 2nd :"+emp2.getId());
		return empData;
	}

	@RequestMapping(value = "/employee/getAll", method = RequestMethod.GET)
	public HashMap<Integer, Employee> getAllEmployees() {
		return empData;
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public Employee getEmployeeById(@PathVariable Integer id) throws Exception {
		if (empData.containsKey(id)) {
			return empData.get(id);
		} else {
			throw new Exception("Employee Id:" + id + " not found");
		}
	}

	@RequestMapping(value = "/employee/add", method = RequestMethod.POST)
	public Employee addEmployee(@RequestBody Employee emp) throws Exception {
		if (empData.containsKey(emp.getId())) {
			throw new Exception("Employee Id:" + emp.getId() + "already exists");
		} else {
			empData.put(emp.getId(), emp);
		}
		return emp;
	}

	@RequestMapping(value = "/employee/update", method = RequestMethod.PUT)
	public Employee updateEmployee(@RequestBody Employee emp) throws Exception {
		if (empData.containsKey(emp.getId())) {
			Employee empUp = empData.get(emp.getId());
			empUp.setId(emp.getId());
			empUp.setName(emp.getName());
			empUp.setDesignation(emp.getDesignation());
			empData.put(empUp.getId(), empUp);
			return empUp;
		} else {
			throw new Exception("Employee Id:" + emp.getId() + " not found");
		}
	}

	@RequestMapping(value = "/employee/delete/{id}", method = RequestMethod.DELETE)
	public Employee deleteEmployee(@PathVariable Integer id) throws Exception{
		if(empData.containsKey(id)){
			Employee empDel = empData.get(id);
			empData.remove(id);
			return empDel;
		}else{
			throw new Exception("Employee Id:" + id + " not found");
		}
	}
}