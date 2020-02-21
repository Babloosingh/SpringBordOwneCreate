package com.springBoot.application.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)

public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "Name", nullable = false)
	private String Name;

	@Column(name = "City", nullable = false)
	private String City;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "Order", nullable = false)
	private String Order;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrder() {
		return Order;
	}

	public void setOrder(String order) {
		Order = order;
	}

	@Override
	public String toString() {
		return "Employee{" + "id=" + id + ", " + "Name='" + Name + '\'' + ", City='" + City + '\'' + ", email='" + email
				+ '\'' + ", Order='" + Order + '\'' + '}';
	}

}
