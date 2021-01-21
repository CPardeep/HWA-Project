package com.qa.demo.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.demo.persistence.domain.Dog;
import com.qa.demo.persistence.dto.DogDTO;
import com.qa.demo.services.DogService;

@RestController
@RequestMapping("/dog")
public class DogController {

	private DogService service;

	// Constructor
	public DogController(DogService service) {
		super();
		this.service = service;
	}

	// Post
	@PostMapping("/create")
	public ResponseEntity<DogDTO> create(@RequestBody Dog dog) {
		return new ResponseEntity<DogDTO>(this.service.create(dog), HttpStatus.CREATED);
	}

	// Get
	@GetMapping("/readAll")
	public ResponseEntity<List<DogDTO>> readAll() {
		return ResponseEntity.ok(this.service.readAll());
	}

	// Put
	@PutMapping("/update/{id}")
	public ResponseEntity<DogDTO> update(@PathVariable("id") Long id, @RequestBody Dog dog) {
		return new ResponseEntity<DogDTO>(this.service.update(id, dog), HttpStatus.OK);
	}

	// Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		// Remove Person and return it
		return ResponseEntity.ok(this.service.delete(id));
	}

}
