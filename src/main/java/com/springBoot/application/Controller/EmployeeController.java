package com.springBoot.application.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.application.Model.Employee;
import com.springBoot.application.Repository.EmployeeRepository;
import com.springBoot.application.exception.ResourceNotFoundException;

@RestController
//@RequestMapping("employee")
public class EmployeeController {

	@RequestMapping("/")
	public String home() {
		return "Hello World!";
	}

	@Autowired
	private EmployeeRepository CrudRepository;

	@GetMapping("/employee")
	public List<Employee> getAllemployes() {

		return (List<Employee>) CrudRepository.findAll();
	}


	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getUsersById(@PathVariable(value = "id") Long employesId)
			throws ResourceNotFoundException {
		Employee employee = CrudRepository.findById(employesId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + employesId));
		return ResponseEntity.ok().body(employee);
	}

	@PostMapping("/employees")
	public Employee createEmployees(@Valid @RequestBody Employee employee) {
		return CrudRepository.save(employee);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employesId,
			@Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {

		Employee employee = CrudRepository.findById(employesId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + employesId));

		employee.setName(employeeDetails.getName());
		employee.setCity(employeeDetails.getCity());
		employee.setEmail(employeeDetails.getEmail());
		employee.setOrder(employeeDetails.getOrder());

		final Employee updatedEmployes = CrudRepository.save(employee);
		return ResponseEntity.ok(updatedEmployes);
	}

	@DeleteMapping("/employee/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId) throws Exception {
		Employee employee = CrudRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + employeeId));

		CrudRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
