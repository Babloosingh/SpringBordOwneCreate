package com.springBoot.application.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springBoot.application.Model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
