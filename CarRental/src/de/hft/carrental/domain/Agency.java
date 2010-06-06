package de.hft.carrental.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AGENCY")
public final class Agency {

	private Integer id;

	private String name;

	private Set<Branch> branches;

	private Set<Booking> bookings;

	@Id
	@GeneratedValue
	@Column(name = "ID", updatable = false, nullable = false, length = 45)
	public Integer getId() {
		return id;
	}

	@Column(name = "NAME", updatable = true, nullable = false)
	public String getName() {
		return name;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "agency", orphanRemoval = true, targetEntity = Branch.class)
	public Set<Branch> getBranches() {
		return branches;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "agency", orphanRemoval = true, targetEntity = Booking.class)
	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBranches(Set<Branch> branches) {
		this.branches = branches;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}
}
