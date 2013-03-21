package com.gailo22.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Access(AccessType.FIELD)
public class Address {

	private String street;

	private String city;

	private String state;

	@Column(name = "ZIP_CODE")
	private String zip;

	public String getStreet() {
		return this.street;
	}

	public void setStreet(final String street) {
		this.street = street;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(final String city) {
		this.city = city;
	}

	public String getState() {
		return this.state;
	}

	public void setState(final String state) {
		this.state = state;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(final String zip) {
		this.zip = zip;
	}

}
