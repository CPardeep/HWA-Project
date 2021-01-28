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
import com.qa.demo.persistence.domain.Shelter;
import com.qa.demo.persistence.dto.ShelterDTO;

@SpringBootTest(classes = HwaProjectApplication.class)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:testSchema.sql",
		"classpath:data-test.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles = "test")
class TestShelterController {

	@Autowired
	private MockMvc mock;

	@Autowired
	private ObjectMapper jsonifier;

	@Autowired
	private ModelMapper mapper;

	// Data
	private final Shelter TEST_SHELTER = new Shelter("2nd Home Shelter", "115 Cannock Road", "WV101LF", null);
	private final Shelter TEST_SHELTER1 = new Shelter(1L, "Chetans Shelter", "73 Bradley Road", "WV22AZ", null);
	private final Long SHELTER_ID = 1L;

	// Shelter to mapping ShelterDTO
	private ShelterDTO mapToDTO(Shelter shelter) {
		return this.mapper.map(shelter, ShelterDTO.class);
	}

	// Post
	@Test
	public void createDogTest() throws Exception {

		// Prepare test
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST, "/shelter/create")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.content(this.jsonifier.writeValueAsString(TEST_SHELTER));

		TEST_SHELTER.setID(2L);

		// Assertion Check
		ResultMatcher matchContent = MockMvcResultMatchers.content()
				.json(this.jsonifier.writeValueAsString(mapToDTO(TEST_SHELTER)));
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();

		// Perform
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}

	// Get
	@Test
	public void readOneShelterTest() throws Exception {
		// Prepare test
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET,
				"/shelter/read/" + SHELTER_ID);

		// Assertion Check
		ResultMatcher matchContent = MockMvcResultMatchers.content()
				.json(this.jsonifier.writeValueAsString(mapToDTO(TEST_SHELTER1)));
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();

		// Perform
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);

	}

	@Test
	public void readAllShelterTest() throws Exception {

		// Prepare Test
		List<ShelterDTO> LISTOFSHELTERS = new ArrayList<>();
		LISTOFSHELTERS.add(mapToDTO(TEST_SHELTER1));

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET, "/shelter/readAll");

		// Assertion Check
		ResultMatcher matchContent = MockMvcResultMatchers.content()
				.json(this.jsonifier.writeValueAsString(LISTOFSHELTERS));
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();

		// Perform
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}

	// Put
	@Test
	public void updateCat() throws Exception {

		// Prepare Test
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
				.request(HttpMethod.PUT, "/shelter/update/" + SHELTER_ID).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(this.jsonifier.writeValueAsString(TEST_SHELTER));

		TEST_SHELTER.setID(1L);

		// Assertion Check
		ResultMatcher matchContent = MockMvcResultMatchers.content()
				.json(this.jsonifier.writeValueAsString(mapToDTO(TEST_SHELTER)));
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isAccepted();

		// Perform
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}

	// Delete
	@Test
	public void deleteCat() throws Exception {
		// Prepare Test
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.DELETE,
				"/shelter/delete/" + SHELTER_ID);

		// Assertion Check
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isNoContent();

		// Perform
		this.mock.perform(mockRequest).andExpect(matchStatus);
	}

}
