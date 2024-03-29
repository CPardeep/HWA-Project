package com.qa.demo.services;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.qa.demo.exception.DogNotFoundException;
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

	// Read
	public DogDTO readById(Long id) {
		Dog result = this.repo.findById(id).orElseThrow(DogNotFoundException::new);
		//Returns mapped object from dog to dogdto
		return this.mapToDTO(result);
	}

	// Read All
	public List<DogDTO> readAll() {
		// Reads all the tuples in database
		List<Dog> catList = this.repo.findAll();
		// Return the mapped List of all dogs
		return catList.stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	// Update
	public DogDTO update(Long id, Dog dog) {
		// First step is to fetch it from the database
		Dog result = this.repo.findById(id).orElseThrow(DogNotFoundException::new);
		// Then we can set update with new values
		result.setName(dog.getName());
		result.setBreed(dog.getBreed());
		result.setAge(dog.getAge());
		result.setColour(dog.getColour());
		result.setAvailable(dog.getAvailable());
		// Save the the new added set characteristics
		Dog updated = this.repo.save(result);
		return mapToDTO(updated);
	}

	// Delete
	public boolean delete(Long id) {
		// removes the entity
		this.repo.deleteById(id);
		// checks to see if it still exists
		boolean exists = this.repo.existsById(id);
		// returns true if entity no longer exists
		return !exists;
	}

}
