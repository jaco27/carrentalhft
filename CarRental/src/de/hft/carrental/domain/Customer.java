package de.hft.carrental.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
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

	private Set<CustomerAddress> customerAddresses;

	private Set<Booking> bookings;

	@Column(name = "COMPANY_NAME", updatable = true, nullable = true)
	public String getCompanyName() {
		return companyName;
	}

	@Column(name = "CUSTOMER_TYPE", updatable = true, nullable = false)
	public String getCustomerType() {
		return customerType;
	}

	@Column(name = "DATE_OF_BIRTH", updatable = true, nullable = true)
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	@Column(name = "EMAIL", updatable = true, nullable = false, length = 45)
	public String getEmail() {
		return email;
	}

	@Column(name = "FIRST_NAME", updatable = true, nullable = true, length = 45)
	public String getFirstName() {
		return firstName;
	}

	@Id
	@GeneratedValue
	@Column(name = "ID", updatable = false, nullable = false)
	public Integer getId() {
		return id;
	}

	@Column(name = "LOGIN_NAME", updatable = false, nullable = false, length = 45)
	public String getLoginName() {
		return loginName;
	}

	@Column(name = "PASSWORD", updatable = true, nullable = false, length = 45)
	public String getPassword() {
		return password;
	}

	@Column(name = "REGISTER_DATE", updatable = false, nullable = false)
	public Date getRegisterDate() {
		return registerDate;
	}

	@Column(name = "SURNAME", updatable = true, nullable = true, length = 45)
	public String getSurname() {
		return surname;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", orphanRemoval = true, targetEntity = CustomerAddress.class)
	public Set<CustomerAddress> getCustomerAddresses() {
		return customerAddresses;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", orphanRemoval = true, targetEntity = Booking.class)
	public Set<Booking> getBookings() {
		return bookings;
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

	public void setBookings(Set<Booking> bookings) {
		if (this.bookings == null) {
			this.bookings = bookings;
		} else {
			this.bookings.clear();
			this.bookings.addAll(bookings);
		}
	}

	public void setCustomerAddresses(Set<CustomerAddress> customerAddresses) {
		if (this.customerAddresses == null) {
			this.customerAddresses = customerAddresses;
		} else {
			this.customerAddresses.clear();
			this.customerAddresses.addAll(customerAddresses);
		}
	}
}
