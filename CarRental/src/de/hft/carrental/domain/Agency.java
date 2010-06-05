package de.hft.carrental.domain;

import java.util.Set;

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

	@OneToMany(mappedBy = "agency", orphanRemoval = true, targetEntity = Branch.class)
	public Set<Branch> getBranches() {
		return branches;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
