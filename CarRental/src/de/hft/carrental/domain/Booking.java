package de.hft.carrental.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKING")
public final class Booking {

	private Date bookingDate;

	private Integer bookingNumber;

	private Date returnDate;

	private Customer customer;

	private Agency agency;

	private Car car;

	@Column(name = "BOOKING_DATE", updatable = true, nullable = false)
	public Date getBookingDate() {
		return bookingDate;
	}

	@Id
	@GeneratedValue
	@Column(name = "BOOKING_NUMBER", updatable = false, nullable = false)
	public Integer getBookingNumber() {
		return bookingNumber;
	}

	@Column(name = "RETURN_DATE", updatable = true, nullable = false)
	public Date getReturnDate() {
		return returnDate;
	}

	@ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = Customer.class)
	@JoinColumn(name = "CUSTOMER_ID", updatable = false, nullable = false, referencedColumnName = "ID")
	public Customer getCustomer() {
		return customer;
	}

	@ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = Agency.class)
	@JoinColumn(name = "AGENCY_ID", updatable = false, nullable = false, referencedColumnName = "ID")
	public Agency getAgency() {
		return agency;
	}

	@ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = Car.class)
	@JoinColumn(name = "CAR_ID", updatable = false, nullable = false, referencedColumnName = "ID")
	public Car getCar() {
		return car;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public void setBookingNumber(Integer bookingNumber) {
		this.bookingNumber = bookingNumber;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}
