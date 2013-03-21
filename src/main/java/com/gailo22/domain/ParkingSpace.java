package com.gailo22.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ParkingSpace {
	@Id
	private int id;

	private int lot;

	private String location;

	@OneToOne(mappedBy = "parkingSpace")
	private Employee employee;

	public int getId() {
		return this.id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public int getLot() {
		return this.lot;
	}

	public void setLot(final int lot) {
		this.lot = lot;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(final String location) {
		this.location = location;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(final Employee employee) {
		this.employee = employee;
	}

}
