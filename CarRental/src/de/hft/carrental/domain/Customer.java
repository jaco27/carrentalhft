package de.hft.carrental.domain;

import java.util.Date;

public final class Customer {

	public static final String CUSTOMER_TYPE_PRIVATE = "private";

	public static final String CUSTOMER_TYPE_COMPANY = "company";

	private String companyName;

	private String customerType;

	private Date dateOfBirth;

	private String email;

	private String firstName;

	private Integer id;

	private String loginName;

	private String password;

	private Date registerDate;

	private String surname;

	public String getCompanyName() {
		return companyName;
	}

	public String getCustomerType() {
		return customerType;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public Integer getId() {
		return id;
	}

	public String getLoginName() {
		return loginName;
	}

	public String getPassword() {
		return password;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public String getSurname() {
		return surname;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}
