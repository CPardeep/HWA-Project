package com.qa.demo.persistence.dto;

public class ShelterDTO {
	private Long ID;

	private String name;

	private String addressLine;

	private String postcode;

	public ShelterDTO() {
		super();
	}

	public ShelterDTO(Long iD, String name, String addressLine, String postcode) {
		super();
		ID = iD;
		this.name = name;
		this.addressLine = addressLine;
		this.postcode = postcode;
	}

	@Override
	public String toString() {
		return "ShelterDTO [ID=" + ID + ", name=" + name + ", addressLine=" + addressLine + ", postcode=" + postcode
				+ "]";
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

}
