package com.springBoot.application;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.springBoot.application.Model.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class CreateEmploye {

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
	public void testCreateEmployee() {
		// try {
		System.out.println("Create New User");
		Employee employee = new Employee();
		employee.setName("Raj Singh");
		employee.setEmail("rajsingh@gmail.com");
		employee.setCity("UP");
		employee.setOrder("25");

		ResponseEntity<Employee> postResponse = restTemplate.postForEntity(getRootUrl() + "/employees", employee,
				Employee.class);

		String responseBody = postResponse.getBody().toString();
		System.out.println("Responce Body for create New Employee " + responseBody);

		Assert.assertNotNull(postResponse);
		Assert.assertNotNull(postResponse.getBody());


	}

}
