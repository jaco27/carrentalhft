package de.hft.carrental.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CAR")
public final class Car {

	private Float basePricePerDay;

	private String color;

	private Date dateOfManufacturing;

	private Integer id;

	private String registrationNumber;

	@Column(name = "BASE_PRICE_PER_DAY", updatable = true, nullable = false)
	public Float getBasePricePerDay() {
		return basePricePerDay;
	}

	@Column(name = "COLOR", updatable = true, nullable = false, length = 30)
	public String getColor() {
		return color;
	}

	@Column(name = "DATE_OF_MANUFACTURING", updatable = false, nullable = false)
	public Date getDateOfManufacturing() {
		return dateOfManufacturing;
	}

	@Id
	@GeneratedValue
	@Column(name = "ID", updatable = false, nullable = false)
	public Integer getId() {
		return id;
	}

	@Column(name = "REGISTRATION_NUMBER", updatable = false, nullable = false)
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
