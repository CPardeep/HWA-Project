package com.qa.demo.persistence.dto;

public class DogDTO {

	private Long ID;

	private String name;

	private String breed;

	private int age;

	private String colour;

	private String available;

	public DogDTO() {
		super();
	}

	public DogDTO(Long iD, String name, String breed, int age, String colour, String available) {
		super();
		ID = iD;
		this.name = name;
		this.breed = breed;
		this.age = age;
		this.colour = colour;
		this.available = available;
	}
	
	@Override
	public String toString() {
		return "DogDTO [ID=" + ID + ", name=" + name + ", breed=" + breed + ", age=" + age + ", colour=" + colour
				+ ", available=" + available + "]";
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

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

}
