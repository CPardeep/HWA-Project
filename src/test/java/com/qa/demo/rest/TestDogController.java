package com.qa.demo.rest;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.demo.HwaProjectApplication;
import com.qa.demo.persistence.domain.Dog;
import com.qa.demo.persistence.domain.Shelter;
import com.qa.demo.persistence.dto.DogDTO;

@SpringBootTest(classes = HwaProjectApplication.class)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:testSchema.sql", "classpath:data-test.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles = "test")
class TestDogController {

	@Autowired
	private MockMvc mock;

	@Autowired
	private ObjectMapper jsonifier;

	@Autowired
	private ModelMapper mapper;

	// Data
	private final Shelter TEST_SHELTER = new Shelter(1L, "73 Bradley Road", "Chetans Shelter", "WV22AZ", null);
	private final Dog DOG_TEST = new Dog("Sony", "Husky", 1, "White", "No", TEST_SHELTER);
	private final Dog DOG_TEST2 = new Dog(1L, "rokit", "Akita", 1, "black", "Yes", TEST_SHELTER);
	private final Dog DOG_TEST3 = new Dog(2L, "powel", "Bulldog", 2, "black", "Yes", TEST_SHELTER);
	private final Long DOG_ID = 1L;
	
	// Dog to mapping DogDTO
	private DogDTO mapToDTO(Dog dog) {
		return this.mapper.map(dog, DogDTO.class);
	}

	// Post
	@Test
	void createDogTest() throws Exception {

		// Prepare test
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST, "/dog/create")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.content(this.jsonifier.writeValueAsString(DOG_TEST));

		DOG_TEST.setID(3L);

		// Assertion Check
		ResultMatcher matchContent = MockMvcResultMatchers.content()
				.json(this.jsonifier.writeValueAsString(mapToDTO(DOG_TEST)));
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();

		// Perform
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}

	// Get
	@Test
	void readOneDogTest() throws Exception {
		// Prepare test
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET,
				"/dog/read/" + DOG_ID);

		// Assertion CHeck
		ResultMatcher matchContent = MockMvcResultMatchers.content()
				.json(this.jsonifier.writeValueAsString(mapToDTO(DOG_TEST2)));
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();

		// Perform
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);

	}

	// ReadAll
	@Test
	void readAllDogTest() throws Exception {

		// Prepare Test
		List<DogDTO> LISTOFDOGS = new ArrayList<>();
		LISTOFDOGS.add(mapToDTO(DOG_TEST2));
		LISTOFDOGS.add(mapToDTO(DOG_TEST3));

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET, "/dog/readAll");

		// Assertion CHeck
		ResultMatcher matchContent = MockMvcResultMatchers.content()
				.json(this.jsonifier.writeValueAsString(LISTOFDOGS));
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();

		// Perform
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}

	// Put
	@Test
	void updateCat() throws Exception {

		// Prepare Test
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
				.request(HttpMethod.PUT, "/dog/update/" + DOG_ID).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(this.jsonifier.writeValueAsString(DOG_TEST));

		DOG_TEST.setID(1L);

		// Assertion Check
		ResultMatcher matchContent = MockMvcResultMatchers.content()
				.json(this.jsonifier.writeValueAsString(mapToDTO(DOG_TEST)));
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isAccepted();

		// Perform
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}

	// Delete
	@Test
	void deleteCat() throws Exception {
		// Prepare Test
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.DELETE,
				"/dog/delete/" + DOG_ID);

		// Assertion CHeck
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isNoContent();

		// Perform
		this.mock.perform(mockRequest).andExpect(matchStatus);
	}

}
