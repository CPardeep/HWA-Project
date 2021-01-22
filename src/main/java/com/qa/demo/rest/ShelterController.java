package com.qa.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qa.demo.persistence.domain.Shelter;
import com.qa.demo.persistence.dto.ShelterDTO;
import com.qa.demo.services.ShelterService;

@RestController
@RequestMapping("/shelter")
public class ShelterController {

	private ShelterService service;

	public ShelterController(ShelterService service) {
		super();
		this.service = service;
	}

	// Post
	@PostMapping("/create")
	public ResponseEntity<ShelterDTO> create(@RequestBody Shelter shelter) {
		return new ResponseEntity<ShelterDTO>(this.service.create(shelter), HttpStatus.CREATED);
	}

}