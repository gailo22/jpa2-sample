package com.gailo22.domain;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {

	@Id
	private int id;

	private String name;

	@ManyToMany(mappedBy = "projects")
	private Collection<Employee> employees;

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

	public Collection<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(final Collection<Employee> employees) {
		this.employees = employees;
	}

}
