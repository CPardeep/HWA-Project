package com.qa.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.qa.demo.HwaProjectApplication;
import com.qa.demo.persistence.domain.Dog;
import com.qa.demo.persistence.domain.Shelter;
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

	// Data
	private final Shelter TEST_SHELTER = new Shelter(1L, "73 Bradley Road", "Chetans Shelter", "WV22AZ", null);
	private final Dog TEST_DOG = new Dog("Kev", "Lebra", 1, "black", "Reserved", TEST_SHELTER);
	private final Long TEST_ID = 1L;

	private DogDTO mapToDTO(Dog dog) {
		return this.mapper.map(dog, DogDTO.class);
	}

	@Test
	// create
	void createTest() {
		// Setup
		TEST_DOG.setID(1L);

		// Rules --> this is used when it is deffered to another class
		Mockito.when(this.repo.save(TEST_DOG)).thenReturn(TEST_DOG);

		// Action --> this is the part of the method you want to test && // Assertion
		// --> this is where you check what the method returns is equal to what is
		// expected.
		Assertions.assertThat(this.service.create(TEST_DOG)).isEqualTo(mapToDTO(TEST_DOG));

		// Verify --> this is done to see how many times a method spits out stuff
		Mockito.verify(this.repo, Mockito.times(1)).save(TEST_DOG);
	}

	@Test
	// read
	void readTest() {
		// Setup
		TEST_DOG.setID(1L);

		// Rules --> this is used when it is deffered to another class
		Mockito.when(this.repo.findById(TEST_ID)).thenReturn(Optional.of(TEST_DOG));

		// Action --> this is the part of the method you want to test && // Assertion
		// --> this is where you check what the method returns is equal to what is
		// expected.
		Assertions.assertThat(mapToDTO(TEST_DOG)).isEqualTo(this.service.readById(TEST_ID));

		// Verify --> this is done to see how many times a method spits out stuff
		Mockito.verify(this.repo, times(1)).findById(TEST_ID);
	}

	@Test
	// ReadAll
	void readAllTest() {
		// Setup
		TEST_DOG.setID(1L);
		List<Dog> DOGLIST = new ArrayList<Dog>();
		DOGLIST.add(TEST_DOG);
		List<DogDTO> DOGDTOLIST = new ArrayList<DogDTO>();
		DOGDTOLIST.add(mapToDTO(TEST_DOG));
		
		// Rules --> this is used when it is deffered to another class
		Mockito.when(this.repo.findAll()).thenReturn(DOGLIST);

		// Action --> this is the part of the method you want to test && // Assertion
		// --> this is where you check what the method returns is equal to what is
		// expected.
		Assertions.assertThat(this.service.readAll()).isEqualTo(DOGDTOLIST);

		// Verify --> this is done to see how many times a method spits out stuff
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	// read
	void updateTest() {
		// Setup
		TEST_DOG.setID(1L);
		Dog TEST_UPDATEDDOG = new Dog(1L, "Savy", "Lebra", 1, "black", "Reserved", TEST_SHELTER);

		// Rules --> this is used when it is deffered to another class
		Mockito.when(this.repo.findById(TEST_ID)).thenReturn(Optional.of(TEST_DOG));
		Mockito.when(this.repo.save(TEST_UPDATEDDOG)).thenReturn(TEST_UPDATEDDOG);
		
		// Action --> this is the part of the method you want to test && // Assertion
		// --> this is where you check what the method returns is equal to what is
		// expected.
		Assertions.assertThat(mapToDTO(TEST_UPDATEDDOG)).isEqualTo(this.service.update(TEST_ID, TEST_UPDATEDDOG));

		// Verify --> this is done to see how many times a method spits out stuff
		Mockito.verify(this.repo, times(1)).findById(TEST_ID);
		Mockito.verify(this.repo, times(1)).save(TEST_UPDATEDDOG);
	}

	@Test
	// Delete
	void deleteTest() {

		// Action --> this is the part of the method you want to test && // Assertion
		// --> this is where you check what the method returns is equal to what is
		// expected.
		Assertions.assertThat(this.service.delete(TEST_ID)).isTrue();

	}

}
