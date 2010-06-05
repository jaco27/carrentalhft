package de.hft.carrental.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKING")
public final class Booking {

	private Date bookingDate;

	private Integer bookingNumber;

	private Date returnDate;

	@Column(name = "BOOKING_DATE", nullable = false)
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

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public void setBookingNumber(Integer bookingNumber) {
		this.bookingNumber = bookingNumber;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

}
