package com.springBoot.application;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.springBoot.application.application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Get_EmploeeAll {

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
	public void testGetAllEmploee() {
		// try {

		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/employee", HttpMethod.GET, entity,
				String.class);
		System.out.println(response);

		String responseBody = response.getBody().toString();
		System.out.println("Responce Body is for All list user " + responseBody);

		Assert.assertNotNull(response.getBody());

		// } catch (Exception e) {
		// e.printStackTrace();
		// }
	}

}
