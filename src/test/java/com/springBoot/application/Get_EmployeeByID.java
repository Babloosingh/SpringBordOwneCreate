package com.springBoot.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.AssertJUnit;

import com.springBoot.application.Model.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Get_EmployeeByID {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;

	}

	@Test
	public void contextLoads() {

	}

	@Test
	public void testGetUserById() {
		Employee employee = restTemplate.getForObject(getRootUrl() + "/employees/5", Employee.class);
		System.out.println(employee.getName());
		System.out.println(employee.getCity());
		AssertJUnit.assertNotNull(employee);
	}

}
