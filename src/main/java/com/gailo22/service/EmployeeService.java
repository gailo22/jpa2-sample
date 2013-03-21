package com.gailo22.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.gailo22.domain.Employee;

public class EmployeeService {

	protected EntityManager em;

	public EmployeeService(final EntityManager em) {
		this.em = em;
	}

	public Employee createEmployee(final int id, final String name, final long salary) {
		final Employee employee = new Employee(id);
		employee.setName(name);
		employee.setSalary(salary);
		this.em.persist(employee);
		return employee;
	}

	public void removeEmployee(final int id) {
		final Employee employee = findEmployee(id);
		if (employee != null) {
			this.em.remove(employee);
		}
	}

	public Employee raiseEmployeeSalary(final int id, final long raise) {
		final Employee employee = findEmployee(id);
		if (employee != null) {
			employee.setSalary(employee.getSalary() + raise);
		}
		return employee;
	}

	public Employee updateEmployee(final Employee employee) {
		final Employee emp = this.em.merge(employee);
		this.em.flush();
		return emp;
	}

	public Employee findEmployee(final int id) {
		return this.em.find(Employee.class, id);
	}

	public List<Employee> findAllEmployees() {
		final TypedQuery<Employee> query = this.em.createQuery("SELECT e FROM Employee e", Employee.class);
		return query.getResultList();
	}

}
