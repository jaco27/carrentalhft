package de.hft.carrental.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BRANCH_ADDRESS")
public final class BranchAddress {

	private String cityName;

	private String country;

	private Integer id;

	private String phoneNumber;

	private String postalCode;

	private String streetNumber;

	@Column(name = "CITY_NAME", updatable = false, nullable = false, length = 45)
	public String getCityName() {
		return cityName;
	}

	@Column(name = "COUNTRY", updatable = false, nullable = false, length = 45)
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

}
