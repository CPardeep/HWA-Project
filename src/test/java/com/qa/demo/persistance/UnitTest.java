package com.qa.demo.persistance;

import org.junit.jupiter.api.Test;

import com.qa.demo.persistence.domain.Dog;
import com.qa.demo.persistence.domain.Shelter;
import com.qa.demo.persistence.dto.DogDTO;
import com.qa.demo.persistence.dto.ShelterDTO;

import nl.jqno.equalsverifier.EqualsVerifier;

class UnitTest {

	@Test
	void testShelter() {
		EqualsVerifier.simple().forClass(Dog.class)
		.withPrefabValues(Shelter.class, new Shelter(), new Shelter(1L, "CBS shell", "73 Bradley Lane", "WV22AZ", null)).verify();
	}
	
	@Test
	void testDog() {
		EqualsVerifier.simple().forClass(Dog.class)
		.withPrefabValues(Dog.class, new Dog(), new Dog(1L, "rokit", "lebra", 1, "#0000", "yes", null)).verify();
	}
	
	@Test
	void testShelterDTO() {
		EqualsVerifier.simple().forClass(ShelterDTO.class)
		.withPrefabValues(ShelterDTO.class, new ShelterDTO(), new ShelterDTO(1L, "CBS shell", "73 Bradley Lane", "WV22AZ")).verify();
	}
	
	@Test
	void testDogDTO() {
		EqualsVerifier.simple().forClass(ShelterDTO.class)
		.withPrefabValues(DogDTO.class, new DogDTO(), new DogDTO(1L, "rokit", "lebra", 1, "#0000", "yes")).verify();
	}
	

}
