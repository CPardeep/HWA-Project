package com.qa.demo.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.demo.HwaProjectApplication;
import com.qa.demo.persistence.domain.Dog;
import com.qa.demo.persistence.dto.DogDTO;
import com.qa.demo.persistence.repos.DogRepo;
import com.qa.demo.services.DogService;

@SpringBootTest(classes = HwaProjectApplication.class)
class DogServiceTest {

	@Autowired // InjectMocks
	private DogService service;

	@Autowired
	private ModelMapper mapper;

	@MockBean // Mocks
	private DogRepo repo;

	private DogDTO mapToDTO(Dog dog) {
		return this.mapper.map(dog, DogDTO.class);
	}

	@Test
	// create
	public void create() {
		// Setup
		Dog TEST_DOG = new Dog("Kev", "Lebra", 1, "black", "Reserved");
		Dog TEST_DOGID = TEST_DOG;
		TEST_DOGID.setID(1L);

		// Rules --> this is used when it is deffered to another class
		Mockito.when(this.repo.save(TEST_DOG)).thenReturn(TEST_DOG);

		// Action --> this is the part of the method you want to test
		// Assertion --> this is where you check what the method returns is equal to
		// what is expected.
		Assertions.assertThat(this.service.create(TEST_DOG)).isEqualTo(mapToDTO(TEST_DOG));

		// Verify --> this is done to see how many times a method spits out stuff
		Mockito.verify(this.repo, Mockito.times(1)).save(TEST_DOG);
	}

}
