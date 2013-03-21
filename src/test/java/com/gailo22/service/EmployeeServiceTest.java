package com.gailo22.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gailo22.domain.Employee;
import com.gailo22.domain.EmployeeType;
import com.gailo22.util.SessionManager;

import static org.hamcrest.core.Is.is;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class EmployeeServiceTest {

	private EmployeeService employeeService;

	private EntityManager em;

	@Before
	public void init() {
		this.em = SessionManager.getEntityManager();
		this.employeeService = new EmployeeService(this.em);
	}

	@After
	public void tearDown() {
		this.em.close();
	}

	@Test
	public void should() {
		// Save
		this.em.getTransaction().begin();
		Employee employee = this.employeeService.createEmployee(158, "John Doe", 45000);
		this.em.getTransaction().commit();
		assertThat(employee.getId(), is(158));

		// Find one
		employee = this.employeeService.findEmployee(158);
		assertThat(employee.getId(), is(158));

		// Find all
		final List<Employee> employeeList = this.employeeService.findAllEmployees();
		assertThat(employeeList.size(), is(1));

		// Update
		this.em.getTransaction().begin();
		employee = this.employeeService.raiseEmployeeSalary(158, 1000);
		this.em.getTransaction().commit();
		assertThat(employee.getSalary(), is(46000L));

		// Remove
		this.em.getTransaction().begin();
		this.employeeService.removeEmployee(158);
		this.em.getTransaction().commit();

		assertNull(this.employeeService.findEmployee(158));

	}

	@Test
	public void shouldUpdateEmployeeType() {
		this.em.getTransaction().begin();
		final Employee employee = this.employeeService.createEmployee(123, "abc", 100);
		employee.setEmployeeType(EmployeeType.PART_TIME);
		this.em.getTransaction().commit();

		final Employee findEmployee = this.employeeService.findEmployee(123);
		assertEquals(EmployeeType.PART_TIME, findEmployee.getEmployeeType());

	}

}
