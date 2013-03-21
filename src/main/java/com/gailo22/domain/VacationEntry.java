package com.gailo22.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class VacationEntry {

	@Temporal(TemporalType.DATE)
	private Calendar startDate;

	@Column(name = "DAYS")
	private int daysTaken;

	public Calendar getStartDate() {
		return this.startDate;
	}

	public void setStartDate(final Calendar startDate) {
		this.startDate = startDate;
	}

	public int getDaysTaken() {
		return this.daysTaken;
	}

	public void setDaysTaken(final int daysTaken) {
		this.daysTaken = daysTaken;
	}
}
