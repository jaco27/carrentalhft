package de.hft.carrental.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BRANCH")
public final class Branch {

	private Integer id;

	private String name;

	private Integer agencyId;

	@Id
	@GeneratedValue
	@Column(name = "ID", updatable = false, nullable = false)
	public Integer getId() {
		return id;
	}

	@Column(name = "NAME", updatable = true, nullable = false, length = 45)
	public String getName() {
		return name;
	}

	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@Column(name = "AGENCY_ID", updatable = true, nullable = false)
	public Integer getAgencyId() {
		return agencyId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAgencyId(Integer agencyId) {
		this.agencyId = agencyId;
	}

}
