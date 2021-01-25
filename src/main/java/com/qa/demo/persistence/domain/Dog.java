package com.qa.demo.persistence.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Dog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Exclude
	private Long ID;

	@Column
	private String name;

	@Column
	private String breed;

	@Column
	private int age;

	@Column
	private String colour;

	@Column
	private String available;
	
	@ManyToOne(targetEntity = Shelter.class)
    private Shelter shelter = null;

	public Dog(String name, String breed, int age, String colour, String available) {
		super();
		this.name = name;
		this.breed = breed;
		this.age = age;
		this.colour = colour;
		this.available = available;
	}
	
	

}
