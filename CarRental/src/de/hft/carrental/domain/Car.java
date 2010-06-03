package de.hft.carrental.domain;

import java.util.Date;

public final class Car {

	private Float basePricePerDay;

	private String color;

	private Date dateOfManufacturing;

	private Integer id;

	private String registrationNumber;

	public Float getBasePricePerDay() {
		return basePricePerDay;
	}

	public String getColor() {
		return color;
	}

	public Date getDateOfManufacturing() {
		return dateOfManufacturing;
	}

	public Integer getId() {
		return id;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setBasePricePerDay(Float basePricePerDay) {
		this.basePricePerDay = basePricePerDay;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setDateOfManufacturing(Date dateOfManufacturing) {
		this.dateOfManufacturing = dateOfManufacturing;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

}
