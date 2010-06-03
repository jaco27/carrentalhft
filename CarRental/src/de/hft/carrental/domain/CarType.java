package de.hft.carrental.domain;

public final class CarType {

	private Boolean automatic;

	private Integer id;

	private String name;

	private String producer;

	private String type;

	public Boolean getAutomatic() {
		return automatic;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getProducer() {
		return producer;
	}

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
