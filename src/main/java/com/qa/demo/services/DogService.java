package com.qa.demo.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.qa.demo.persistence.domain.Dog;
import com.qa.demo.persistence.dto.DogDTO;
import com.qa.demo.persistence.repos.DogRepo;

@Service
public class DogService {

	private DogRepo repo;

	private ModelMapper mapper;

	// Constructor
	public DogService(DogRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	// This method uses the MethodMapper to convert Cat to a CatDTO:
	private DogDTO mapToDTO(Dog dog) {
		return this.mapper.map(dog, DogDTO.class);
	}

	// Create
	public DogDTO create(Dog dog) {
		// Saves the person to the database
		Dog result = this.repo.save(dog);
		// Returns the converted dog object into dogDTO
		return this.mapToDTO(result);
	}

}
