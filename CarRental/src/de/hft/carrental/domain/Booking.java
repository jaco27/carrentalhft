package de.hft.carrental.domain;

import java.util.Date;

public final class Booking {

	private Date bookingDate;

	private Integer bookingNumber;

	private Date returnDate;

	public Date getBookingDate() {
		return bookingDate;
	}

	public Integer getBookingNumber() {
		return bookingNumber;
	}

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
