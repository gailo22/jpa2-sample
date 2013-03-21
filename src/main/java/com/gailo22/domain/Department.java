package com.gailo22.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
public class Department {

	@Id
	private int id;

	private String name;

	@OneToMany(mappedBy = "department")
	@OrderBy("name ASC")
	private List<Employee> employees;

	public int getId() {
		return this.id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(final List<Employee> employees) {
		this.employees = employees;
	}

}
