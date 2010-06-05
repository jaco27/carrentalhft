package de.hft.carrental.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_ADDRESS")
public final class CustomerAddress {

	private String cityName;

	private String country;

	private Integer id;

	private String phoneNumber;

	private String postalCode;

	private String streetNumber;

	private Customer customer;

	@Column(name = "CITY_NAME", updatable = true, nullable = false, length = 45)
	public String getCityName() {
		return cityName;
	}

	@Column(name = "COUNTRY", updatable = true, nullable = false, length = 45)
	public String getCountry() {
		return country;
	}

	@Id
	@GeneratedValue
	@Column(name = "ID", updatable = false, nullable = false)
	public Integer getId() {
		return id;
	}

	@Column(name = "PHONE_NUMBER", updatable = true, nullable = false, length = 45)
	public String getPhoneNumber() {
		return phoneNumber;
	}

	@Column(name = "POSTAL_CODE", updatable = true, nullable = false, length = 10)
	public String getPostalCode() {
		return postalCode;
	}

	@Column(name = "STREET_NUMBER", updatable = true, nullable = false, length = 5)
	public String getStreetNumber() {
		return streetNumber;
	}

	@ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = Customer.class)
	@JoinColumn(name = "CUSTOMER_ID", updatable = false, nullable = false, referencedColumnName = "ID")
	public Customer getCustomer() {
		return customer;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
