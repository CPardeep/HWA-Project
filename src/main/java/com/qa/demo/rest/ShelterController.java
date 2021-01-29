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
		return new ResponseEntity<>(this.service.create(shelter), HttpStatus.CREATED);
	}

	// Get
	@GetMapping("/read/{id}")
	public ResponseEntity<ShelterDTO> read(@PathVariable("id") Long id) {
		return ResponseEntity.ok(this.service.readById(id));
	}

	// Get
	@GetMapping("/readAll")
	public ResponseEntity<List<ShelterDTO>> readAll() {
		return ResponseEntity.ok(this.service.readAll());
	}

	// Put
	@PutMapping("/update/{id}")
	public ResponseEntity<ShelterDTO> update(@PathVariable("id") Long id, @RequestBody Shelter shelter) {
		return new ResponseEntity<>(this.service.update(id, shelter), HttpStatus.ACCEPTED);
	}

	// Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		// Remove Person and return it
		return new ResponseEntity<>(this.service.delete(id), HttpStatus.NO_CONTENT);
	}

}
