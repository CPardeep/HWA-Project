package com.qa.demo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.demo.services.ShelterService;

@RestController
@RequestMapping("/shelter")
public class ShelterController {
	
	private ShelterService service;

	public ShelterController(ShelterService service) {
		super();
		this.service = service;
	}
	
	
}
