package com.qa.demo.services;

import java.util.List;
import java.util.stream.Collectors;

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

	// Read All
	public List<DogDTO> readAll() {
		// Reads all the tuples in database
		List<Dog> catList = this.repo.findAll();
		// Return the mapped List of all dogs 
		return catList.stream().map(this::mapToDTO).collect(Collectors.toList());
	}

}
