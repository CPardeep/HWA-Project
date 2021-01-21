package com.qa.demo.services;

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

}
