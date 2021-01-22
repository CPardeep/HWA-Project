package com.qa.demo.services;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.qa.demo.persistence.domain.Shelter;
import com.qa.demo.persistence.dto.ShelterDTO;
import com.qa.demo.persistence.repos.ShelterRepo;

@Service
public class ShelterService {

	private ShelterRepo repo;

	private ModelMapper mapper;

	public ShelterService(ShelterRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	// This method uses the MethodMapper to convert Cat to a CatDTO:
	private ShelterDTO mapToDTO(Shelter shelter) {
		return this.mapper.map(shelter, ShelterDTO.class);
	}

	// Create
	public ShelterDTO create(Shelter shelter) {
		// Saves the shelter to the database
		Shelter result = this.repo.save(shelter);
		// Returns the converted Shelter object into ShelterDTO
		return this.mapToDTO(result);
	}

	// Read All
	public List<ShelterDTO> readAll() {
		// Reads all the tuples in database
		List<Shelter> list = this.repo.findAll();
		// Return the mapped List of all dogs
		return list.stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	// Update
	public ShelterDTO update(Long id, Shelter shelter) {
		// First step is to fetch it from the database
		Shelter result = this.repo.findById(id).orElseThrow();
		// Then we can set update with new values
		result.setName(shelter.getName());
		result.setName(shelter.getAddressLine());
		result.setName(shelter.getPostcode());

		// Save the the new added set characteristics
		Shelter updated = this.repo.save(result);
		return mapToDTO(updated);
	}

}