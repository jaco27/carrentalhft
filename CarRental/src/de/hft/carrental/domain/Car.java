package de.hft.carrental.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CAR")
public final class Car {

	private Float basePricePerDay;

	private String color;

	private Date dateOfManufacturing;

	private Integer id;

	private String registrationNumber;

	private CarType carType;

	private Branch branch;

	private Set<Booking> bookings;

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

	@ManyToOne(optional = false, targetEntity = CarType.class)
	@JoinColumn(name = "CAR_TYPE_ID", updatable = false, nullable = false, referencedColumnName = "ID")
	public CarType getCarType() {
		return carType;
	}

	@ManyToOne(optional = false, targetEntity = Branch.class)
	@JoinColumn(name = "BRANCH_ID", updatable = true, nullable = false, referencedColumnName = "ID")
	public Branch getBranch() {
		return branch;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "car", targetEntity = Booking.class)
	public Set<Booking> getBookings() {
		return bookings;
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

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}
}
