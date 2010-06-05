package de.hft.carrental.domain;

public final class BranchAddress {

	private String cityName;

	private String country;

	private Integer id;

	private String phoneNumber;

	private String postalCode;

	private String streetNumber;

	public String getCityName() {
		return cityName;
	}

	public String getCountry() {
		return country;
	}

	public Integer getId() {
		return id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getPostalCode() {
		return postalCode;
	}

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
