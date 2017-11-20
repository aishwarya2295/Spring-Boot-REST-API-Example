package com.sampleproject.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sampleproject.model.Employee;
import com.sampleproject.service.EmployeeServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(value = EmployeeController.class, secure = false)
public class EmployeeControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeServiceImpl employeeService;
	
	Employee emp = new Employee(1, "Aishwarya", "Software Engineer");
	
	String expected = "{'id':1,'name':'Aishwarya','designation':'Software Engineer'}";
	
	String employeeJson = "{\"id\":1,\"name\":\"Aishwarya\",\"designation\":\"Software Engineer\"}";
	
	@Test
	public void getEmployeeById() throws Exception{
		Mockito.when(employeeService.getEmployeeById(Mockito.anyInt())).thenReturn(emp);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/employees/1").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void addEmployee() throws Exception{		
		
		Mockito.when(employeeService.addEmployee(Mockito.any(Employee.class))).thenReturn(emp);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/employees/").accept(MediaType.APPLICATION_JSON).content(employeeJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String expected = "{'id':1,'name':'Aishwarya','designation':'Software Engineer'}";
		
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void updateEmployee() throws Exception{		
		
		Mockito.when(employeeService.updateEmployee(Mockito.any(Employee.class))).thenReturn(emp);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put(
				"/employees/").accept(MediaType.APPLICATION_JSON).content(employeeJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void deleteEmployee() throws Exception{
		
		Mockito.when(employeeService.deleteEmployee(Mockito.anyInt())).thenReturn(emp);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/employees/1").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
}
