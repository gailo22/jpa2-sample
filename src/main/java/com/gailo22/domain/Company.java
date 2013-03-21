package com.gailo22.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Company {

	@Id
	private String name;

	@Embedded
	private Address address;

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(final Address address) {
		this.address = address;
	}
}
