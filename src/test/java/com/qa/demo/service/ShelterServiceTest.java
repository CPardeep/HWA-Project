package com.qa.demo.service;

import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.qa.demo.HwaProjectApplication;
import com.qa.demo.persistence.domain.Shelter;
import com.qa.demo.persistence.dto.ShelterDTO;
import com.qa.demo.persistence.repos.ShelterRepo;
import com.qa.demo.services.ShelterService;

@SpringBootTest(classes = HwaProjectApplication.class)
class ShelterServiceTest {

	@Autowired // InjectMocks
	private ShelterService service;

	@Autowired
	private ModelMapper mapper;

	@MockBean // Mocks
	private ShelterRepo repo;

	// Data
	private final Shelter TEST_SHELTER = new Shelter("2nd Home Shelter", "115 Cannock Road", "WV101LF", null);
	private final Long SHELTER_ID = 1L;

	private ShelterDTO mapToDTO(Shelter shelter) {
		return this.mapper.map(shelter, ShelterDTO.class);
	}

	@Test
	// create
	void createTest() {
		// Setup
		TEST_SHELTER.setID(SHELTER_ID);

		// Rules --> this is used when it is deffered to another class
		Mockito.when(this.repo.save(TEST_SHELTER)).thenReturn(TEST_SHELTER);

		// Action --> this is the part of the method you want to test && // Assertion
		// --> this is where you check what the method returns is equal to what is
		// expected.
		Assertions.assertThat(this.service.create(TEST_SHELTER)).isEqualTo(mapToDTO(TEST_SHELTER));

		// Verify --> this is done to see how many times a method spits out stuff
		Mockito.verify(this.repo, Mockito.times(1)).save(TEST_SHELTER);
	}

	@Test
	// read
	void readTest() {
		// Setup
		TEST_SHELTER.setID(SHELTER_ID);

		// Rules --> this is used when it is deffered to another class
		Mockito.when(this.repo.findById(SHELTER_ID)).thenReturn(Optional.of(TEST_SHELTER));

		// Action --> this is the part of the method you want to test && // Assertion
		// --> this is where you check what the method returns is equal to what is
		// expected.
		Assertions.assertThat(mapToDTO(TEST_SHELTER)).isEqualTo(this.service.readById(SHELTER_ID));

		// Verify --> this is done to see how many times a method spits out stuff
		Mockito.verify(this.repo, times(1)).findById(SHELTER_ID);
	}

	@Test
	// ReadAll
	void readAllTest() {
		// Setup
		TEST_SHELTER.setID(SHELTER_ID);

		List<Shelter> SHELTERLIST = new ArrayList<Shelter>();
		SHELTERLIST.add(TEST_SHELTER);

		List<ShelterDTO> SHELTERDTOLIST = new ArrayList<ShelterDTO>();
		SHELTERDTOLIST.add(mapToDTO(TEST_SHELTER));

		// Rules --> this is used when it is deffered to another class
		Mockito.when(this.repo.findAll()).thenReturn(SHELTERLIST);

		// Action --> this is the part of the method you want to test && // Assertion
		// --> this is where you check what the method returns is equal to what is
		// expected.
		Assertions.assertThat(this.service.readAll()).isEqualTo(SHELTERDTOLIST);

		// Verify --> this is done to see how many times a method spits out stuff
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	// read
	void updateTest() {
		// Setup
		TEST_SHELTER.setID(SHELTER_ID);
		
		Shelter TEST_UPDATEDSHELTER = new Shelter(1L, "Chetans Shelter", "73 Bradley Road", "WV22AZ", null);

		// Rules --> this is used when it is deffered to another class
		Mockito.when(this.repo.findById(SHELTER_ID)).thenReturn(Optional.of(TEST_SHELTER));
		Mockito.when(this.repo.save(TEST_UPDATEDSHELTER)).thenReturn(TEST_UPDATEDSHELTER);

		// Action --> this is the part of the method you want to test && // Assertion
		// --> this is where you check what the method returns is equal to what is
		// expected.
		Assertions.assertThat(mapToDTO(TEST_UPDATEDSHELTER)).isEqualTo(this.service.update(SHELTER_ID, TEST_UPDATEDSHELTER));

		// Verify --> this is done to see how many times a method spits out stuff
		Mockito.verify(this.repo, times(1)).findById(SHELTER_ID);
		Mockito.verify(this.repo, times(1)).save(TEST_UPDATEDSHELTER);
	}
	
	@Test
	// Delete
	void deleteTest() {

		// Action --> this is the part of the method you want to test && // Assertion
		// --> this is where you check what the method returns is equal to what is
		// expected.
		Assertions.assertThat(this.service.delete(SHELTER_ID)).isTrue();

	}

}
