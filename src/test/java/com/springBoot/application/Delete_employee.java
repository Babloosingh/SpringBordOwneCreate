package com.springBoot.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.testng.AssertJUnit;

import com.springBoot.application.Model.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Delete_employee {
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
	public void testDeletePost() {
		int id = 7;
		Employee employee = restTemplate.getForObject(getRootUrl() + "/employee/" + id, Employee.class);
		AssertJUnit.assertNotNull(employee);

		restTemplate.delete(getRootUrl() + "/employee/" + id);

		System.out.println(employee.toString());

		// babloo

		System.out.println("Delete employee sucessfully ");

		try {
			employee = restTemplate.getForObject(getRootUrl() + "/employee/" + id, Employee.class);
		} catch (final HttpClientErrorException e) {
			AssertJUnit.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}

}
