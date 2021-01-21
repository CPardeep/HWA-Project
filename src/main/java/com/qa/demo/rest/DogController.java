package com.qa.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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


}
