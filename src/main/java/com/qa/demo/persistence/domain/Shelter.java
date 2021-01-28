package com.qa.demo.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Shelter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long ID;

	@Column
	private String name;

	@Column
	private String addressLine;

	@Column
	private String postcode;
	
	@OneToMany(mappedBy = "shelter", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Dog> dogs = new ArrayList<>();

	public Shelter(String name, String addressLine, String postcode, List<Dog> dogs) {
		super();
		this.name = name;
		this.addressLine = addressLine;
		this.postcode = postcode;
		this.dogs = dogs;
	}
	
	
}

