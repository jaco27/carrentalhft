package de.hft.carrental.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BRANCH")
public final class Branch {

	private Integer id;

	private String name;

	private Agency agency;

	private BranchAddress branchAddress;

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

	@ManyToOne(optional = false, targetEntity = Agency.class)
	@JoinColumn(name = "AGENCY_ID", updatable = false, nullable = false, referencedColumnName = "ID")
	public Agency getAgency() {
		return agency;
	}

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "branch", optional = false, orphanRemoval = true, targetEntity = BranchAddress.class)
	public BranchAddress getBranchAddress() {
		return branchAddress;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public void setBranchAddress(BranchAddress address) {
		branchAddress = address;
	}
}
