package de.hft.carrental.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CAR_TYPE")
public final class CarType {

	private Boolean automatic;

	private Integer id;

	private String name;

	private String producer;

	private String type;

	@Column(name = "AUTOMATIC", updatable = true, nullable = false)
	public Boolean getAutomatic() {
		return automatic;
	}

	@Id
	@GeneratedValue
	@Column(name = "ID", updatable = false, nullable = false)
	public Integer getId() {
		return id;
	}

	@Column(name = "NAME", updatable = true, nullable = false)
	public String getName() {
		return name;
	}

	@Column(name = "PRODUCER", updatable = true, nullable = false)
	public String getProducer() {
		return producer;
	}

	@Column(name = "TYPE", updatable = true, nullable = false)
	public String getType() {
		return type;
	}

	public void setAutomatic(Boolean automatic) {
		this.automatic = automatic;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public void setType(String type) {
		this.type = type;
	}

}
