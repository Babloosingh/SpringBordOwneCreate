package com.springBoot.application;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.springBoot.application.Model.Employee;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class Update_Profile {

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
	public void testUpdatePost() {

		int id = 5;
		Employee employee = restTemplate.getForObject(getRootUrl() + "/employees/" + id, Employee.class);
		employee.setName("Dipak Singh");
		employee.setEmail("dipaksingh@gmail.com");

		restTemplate.put(getRootUrl() + "/employees/" + id, employee);

		Employee updatedUser = restTemplate.getForObject(getRootUrl() + "/employees/" + id, Employee.class);

		System.out.println("Update for User  " + updatedUser.toString());

		Assert.assertNotNull(updatedUser);
	}


}


