package com.gailo22.domain;

import java.util.Collection;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	@Id
	private int id;

	private String name;

	private long salary;

	@Enumerated(EnumType.STRING)
	private EmployeeType employeeType;

	@ManyToOne
	@JoinColumn(name = "DEPT_ID")
	private Department department;

	@OneToOne
	@JoinColumn(name = "PSPACE_ID")
	private ParkingSpace parkingSpace;

	@ManyToMany
	@JoinTable(name = "EMP_PROJ", joinColumns = @JoinColumn(name = "EMP_ID"), inverseJoinColumns = @JoinColumn(name = "PROJ_ID"))
	private Collection<Project> projects;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "state", column = @Column(name = "PROVINCE")),
		@AttributeOverride(name = "zip", column = @Column(name = "POSTAL_CODE")) })
	private Address address;

	@ElementCollection(targetClass = VacationEntry.class)
	@CollectionTable(name = "VACATION", joinColumns = @JoinColumn(name = "EMP_ID"))
	@AttributeOverride(name = "daysTaken", column = @Column(name = "DAYS_ABS"))
	private Collection vacationBookings;

	@ElementCollection
	@Column(name = "NICKNAME")
	private Set<String> nickNames;

	public Employee() {
	}

	public Employee(final int id) {
		this.id = id;
	}

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

	public long getSalary() {
		return this.salary;
	}

	public void setSalary(final long salary) {
		this.salary = salary;
	}

	public EmployeeType getEmployeeType() {
		return this.employeeType;
	}

	public void setEmployeeType(final EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(final Department department) {
		this.department = department;
	}

	public ParkingSpace getParkingSpace() {
		return this.parkingSpace;
	}

	public void setParkingSpace(final ParkingSpace parkingSpace) {
		this.parkingSpace = parkingSpace;
	}

	public Collection<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(final Collection<Project> projects) {
		this.projects = projects;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(final Address address) {
		this.address = address;
	}

	public Collection getVacationBookings() {
		return this.vacationBookings;
	}

	public void setVacationBookings(final Collection vacationBookings) {
		this.vacationBookings = vacationBookings;
	}

	public Set<String> getNickNames() {
		return this.nickNames;
	}

	public void setNickNames(final Set<String> nickNames) {
		this.nickNames = nickNames;
	}

}
